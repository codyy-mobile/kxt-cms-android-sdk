package com.codyy.cms.core;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.codyy.cms.MessageDispatcher;
import com.codyy.cms.agora.SignalingToken;
import com.codyy.cms.core.user.User;
import com.codyy.cms.ext.UserMsgModule;
import com.codyy.cms.utils.LoggerUtils;
import com.orhanobut.logger.Logger;

import io.agora.rtm.ErrorInfo;
import io.agora.rtm.IResultCallback;
import io.agora.rtm.RtmClient;
import io.agora.rtm.RtmClientListener;
import io.agora.rtm.RtmMessage;
import io.agora.rtm.RtmStatusCode;

/**
 * Account: User-[liveclassID]-[userId]@codyy.com
 * ChannelId: Channel-[liveclassId]@codyy.com
 */
public class CmsEngine {
    private static final String TAG = "CMS_LOGGER";
    /**
     * RtmClient 支持多实例，每个实例独立工作互不干扰，多个实例创建时可以用相同的 context，但是事件回调 RtmClientListener 必须是不同的实例。
     * 当 RtmClient 实例不再使用的时候，可以调用实例的 destroy 方法进行销毁释放资源。
     */
    private RtmClient mRtmClient;
    private static volatile CmsEngine cmsEngineInstance;
    /**
     * 课堂id
     */
    private int liveClassId;
    private CmsEngineOpts options;

    /**
     * 用户在信令的账号
     */
    private String rtmAccount;
    /**
     * 消息引擎实例
     */
    private MessageEngine msgEngine;

    /**
     * 消息分发对象实例
     *
     * @private
     * @type {MessageDispatcher}
     * @memberof CmsEngine
     */
    private MessageDispatcher msgDispatcher;

    /**
     * 负责创建消息
     *
     * @private
     * @type {MessageFactory}
     * @memberof CmsEngine
     */
    private MessageFactory msgFactory;
    private UserMsgModule userMsgModule;

    public static CmsEngine getInstance() {
        if (cmsEngineInstance == null) {
            synchronized (CmsEngine.class) {
                if (cmsEngineInstance == null) {
                    cmsEngineInstance = new CmsEngine();
                    LoggerUtils.initLogger(TAG);
                }
            }
        }
        return cmsEngineInstance;
    }

    /**
     * 实例化cms engine
     *
     * @param context application context
     * @param opts    配置信息
     */
    public void init(Context context, CmsEngineOpts opts, int liveClassId) {
        try {
            if (opts == null) {
                throw new NullPointerException("CmsEngineOpts is null");
            }
            if (TextUtils.isEmpty(opts.getAppId())) {
                throw new NullPointerException("CmsEngineOpts appId is null");
            }
            if (opts.getTokenLifeTime() <= 0) {
                opts.setTokenLifeTime(CmsConfig.DEFAULT_TOKEN_LIFE_TIME);
            }
            this.options = opts;
            this.liveClassId = liveClassId;
            mRtmClient = RtmClient.createInstance(context, opts.getAppId(), mRtmClientListener);
        } catch (Exception e) {
            Logger.e(Log.getStackTraceString(e));
            throw new RuntimeException("NEED TO check rtc sdk init fatal error\n" + Log.getStackTraceString(e));
        }
    }

    private RtmClientListener mRtmClientListener = new RtmClientListener() {
        @Override
        public void onConnectionStateChanged(int state, int reason) {
            // See the constants defined in RtmStatusCode.ConnectionState and RtmStatusCode.ConnectionChangeReason.
            switch (state) {
                case RtmStatusCode.ConnectionState.CONNECTION_STATE_RECONNECTING:
//                    showToast(getString(R.string.reconnecting));
                    break;
                case RtmStatusCode.ConnectionState.CONNECTION_STATE_ABORTED:
//                    showToast(getString(R.string.account_offline));
//                    setResult(MessageUtil.ACTIVITY_RESULT_CONN_ABORTED);
//                    finish();
                    break;
            }
        }

        @Override
        public void onMessageReceived(RtmMessage message, String peerId) {
            //通过 message.getText 方法可以获取到消息文本内容。接收到的 RtmMessage 消息对象不能重复利用再用于发送
            //peerId 是消息发送方的用户账号 ID。
            try {
                if (msgEngine != null) {
                    msgEngine.onMessage(peerId, message);
                }
            } catch (CmsException e) {
                e.printStackTrace();
            }
        }
    };


    /**
     * 登录信令系统
     * 在登录前,必须先实例化 {@link CmsEngine#init(Context, CmsEngineOpts, int)}
     */
    public void login(LoginOptions loginOptions) {
        if (mRtmClient == null)
            throw new NullPointerException("When use login method ,RtmClient can not be null");
        this.rtmAccount = this.generateRtmAccount(loginOptions.getUserId());
        // 登录 Agora 信令系统
        try {
            mRtmClient.login(SignalingToken.getOneDayToken(options.getAppId(), options.getAppCertificate(), rtmAccount), rtmAccount, new IResultCallback<Void>() {
                @Override
                public void onSuccess(Void responseInfo) {
                    // Login succeeds.
                    msgEngine = new MessageEngine(getInstance(), generateChannelId(), new MsgEngineOpts(getInstance(), mRtmClient, liveClassId, loginOptions.getUserId()));
                    msgDispatcher = new MessageDispatcher();
                    msgFactory = new MessageFactory();
                    initMsgModules(loginOptions, msgFactory);
                }

                @Override
                public void onFailure(ErrorInfo errorInfo) {
                    int errorCode = errorInfo.getErrorCode();
                    // Login fails. See the error codes defined in RtmStatusCode.LoginError.
//                    Logger.e(GeneralEvent.getEventString(errorCode));
                }
            });
        } catch (Exception e) {
            Logger.e(Log.getStackTraceString(e));
            throw new RuntimeException("SignalingToken error\n" + Log.getStackTraceString(e));
        }
    }

    /**
     * 初始化 message modules
     *
     * @protected
     * @memberof CmsEngine
     */
    protected void initMsgModules(LoginOptions loginOpts, MessageFactory msgFactory) {
        this.userMsgModule = new UserMsgModule(new User(loginOpts), msgEngine, msgFactory);
        this.registerMsgModule(this.userMsgModule);
        msgFactory.setUserMsgModule(this.userMsgModule);

//        this.classMsgModule = new ClassMsgModule(this.getMessageEngine(), msgFactory);
//        this.registerMsgModule(this.classMsgModule);
//
//        this.textchatMsgModule = new TextchatMsgModule(this.getMessageEngine(), msgFactory);
//        this.registerMsgModule(this.textchatMsgModule);
//
//        this.whiteboardMsgModule = new WhiteboardMsgModule(this.getMessageEngine(), msgFactory);
//        this.registerMsgModule(this.whiteboardMsgModule);
//
//        this.sysMsgModule = new SysMsgModule(this.getMessageEngine(), msgFactory);
//        this.registerMsgModule(this.sysMsgModule);
    }

    /**
     * Return instance of UserMsgModule.
     *
     * @returns {UserMsgModule}
     * @memberof CmsEngine
     */
    UserMsgModule getUserMsgModule() {
        return this.userMsgModule;
    }

    /**
     * Register message module and subscribe message.
     *
     * @param {MessageModule} msgModule
     * @memberof CmsEngine
     */
    public void registerMsgModule(MessageModule msgModule) {
        this.getMsgDispatcher().subscribe(msgModule);
    }

    /**
     * Unregister message module.
     *
     * @param {MessageModule} msgModule
     * @memberof CmsEngine
     */
    public void unregisterMsgModule(MessageModule msgModule) {
        this.getMsgDispatcher().unsubscribe(msgModule);
    }

    public MessageDispatcher getMsgDispatcher() {
        return msgDispatcher;
    }

    public MessageFactory getMsgFactory() {
        return msgFactory;
    }


    public String getRtmAccount() {
        return rtmAccount;
    }

    public MessageEngine getMsgEngine() {
        return msgEngine;
    }

    /**
     * 退出信令系统
     */
    public void logout() {
        unregisterMsgModule(this.userMsgModule);
        if (msgEngine != null) {
            msgEngine.channelLeave();
        }
        if (mRtmClient != null) {
            mRtmClient.logout(null);
        }
    }


    /**
     * Generate channel id with channel and live class id.
     */
    private String generateChannelId() {
        return "Channel" + CmsConfig.SEPARATOR_OF_ACCOUNT + this.liveClassId + CmsConfig.SUFFIX_OF_ACCOUNT;
    }

    /**
     * Generate rtmAccount with live class id and user id, the rtmAccount is used to register in Agora RTM system.
     * Account: User-[liveclassID]-[userId]@codyy.com
     */
    private String generateRtmAccount(int userId) {
        return "User" + CmsConfig.SEPARATOR_OF_ACCOUNT + this.liveClassId + CmsConfig.SEPARATOR_OF_ACCOUNT
                + userId + CmsConfig.SUFFIX_OF_ACCOUNT;
    }

    /**
     * default is {@link RtmClient#LOG_FILTER_DEBUG}
     */
    public void setLogLevel(int logLevel) {
//        LoggerUtils.setLogLevel(logLevel);
        mRtmClient.setLogFilter(logLevel);
    }

    public RtmClient getRtmClient() {
        return mRtmClient;
    }
}
