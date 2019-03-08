package com.codyy.cms.core;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.codyy.cms.agora.SignalingToken;
import com.codyy.cms.core.user.User;
import com.codyy.cms.utils.GeneralEvent;
import com.codyy.cms.utils.LoggerUtils;
import com.orhanobut.logger.Logger;

import io.agora.AgoraAPI;
import io.agora.AgoraAPIOnlySignal;

/**
 * Account: User-[liveclassID]-[userId]@codyy.com
 * ChannelId: Channel-[liveclassId]@codyy.com
 */
public class CmsEngine {
    private static final String TAG = "CMS_LOGGER";
    private AgoraAPIOnlySignal signal;
    private static volatile CmsEngine cmsEngineInstance;
    /**
     * 课堂id
     */
    private int liveClassId;
    private User userInfo;
    private CmsEngineOpts options;
    private int msgCount = 0;
    /**
     * 固定值0
     */
    private static final int uid = 0;
    /**
     * 暂时无用，设置为空
     */
    private static final String deviceID = "";
    /**
     * 用户在信令的账号
     */
    private String account;

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
    public void setupCmsEngine(Context context, CmsEngineOpts opts) {
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
            signal = AgoraAPIOnlySignal.getInstance(context, opts.getAppId());
            validateSignal();
            callbackSet();

        } catch (Exception e) {
            Logger.e(Log.getStackTraceString(e));
            throw new RuntimeException("NEED TO check rtc sdk init fatal error\n" + Log.getStackTraceString(e));
        }
    }

    /**
     * 登录信令系统
     * 在登录前,必须先实例化 {@link CmsEngine#setupCmsEngine(Context, CmsEngineOpts)}
     */
    public void login(int liveClassId, int userId, String userName, String userNumber) {
        validateSignal();
        this.liveClassId = liveClassId;
        this.userInfo = new User(userId, userName, userNumber);
        this.account = this.generateAccount();
        // 登录 Agora 信令系统
        try {
            signal.login(options.getAppId(), account, SignalingToken.getOneDayToken(options.getAppId(), options.getAppCertificate(), account), uid, deviceID);
        } catch (Exception e) {
            Logger.e(Log.getStackTraceString(e));
            throw new RuntimeException("SignalingToken error\n" + Log.getStackTraceString(e));
        }
    }

    /**
     * 信令监听回调
     */
    private void callbackSet() {
        signal.callbackSet(new AgoraAPI.CallBack() {
            @Override
            public void onLoginSuccess(int uid, int fd) {//uid:固定填0;fd:小阔不使用此参数,Agora 内部参数
                super.onLoginSuccess(uid, fd);
                channelJoin();
            }

            @Override
            public void onLogout(int ecode) {//错误代码
                super.onLogout(ecode);
                Logger.d("ecode:" + ecode, GeneralEvent.getEventString(ecode));
            }

            @Override
            public void onLoginFailed(int ecode) {//错误代码
                super.onLoginFailed(ecode);
                Logger.d("ecode:" + ecode, GeneralEvent.getEventString(ecode));
            }

            @Override
            public void onMessageSendSuccess(String messageID) {//消息发送成功回调
                super.onMessageSendSuccess(messageID);
            }

            @Override
            public void onMessageSendError(String messageID, int ecode) {//消息发送失败回调
                super.onMessageSendError(messageID, ecode);
                Logger.d("ecode:" + ecode, GeneralEvent.getEventString(ecode));
            }

            @Override
            public void onMessageInstantReceive(String account, int uid, String msg) {
                super.onMessageInstantReceive(account, uid, msg);//对端收到消息回调
            }

            @Override
            public void onChannelJoined(String channelID) {
                super.onChannelJoined(channelID);// 设置加入频道成功回调
            }

            @Override
            public void onChannelJoinFailed(String channelID, int ecode) {
                super.onChannelJoinFailed(channelID, ecode);// 设置加入频道失败回调
                Logger.d("ecode:" + ecode, GeneralEvent.getEventString(ecode));
            }
        });
    }

    /**
     * 发送点对点消息
     */
    public void messageInstantSend(String msg) {
        validateSignal();
        signal.messageInstantSend(account, uid, msg, getNextMsgId());
    }

    /**
     * 发送频道消息
     */
    public void messageChannelSend(String msg) {
        validateSignal();
        signal.messageChannelSend(generateChannelId(), msg, getNextMsgId());
    }

    // 加入频道
    private void channelJoin() {
        validateSignal();
        signal.channelJoin(generateChannelId());
    }
    // 退出频道
    private void channelLeave() {
        validateSignal();
        signal.channelLeave(generateChannelId());
    }

    private void validateSignal() {
        if (signal == null) {
            throw new NullPointerException("AgoraAPIOnlySignal is null");
        }
    }

    /**
     * 退出信令系统
     */
    public void logout() {
        validateSignal();
        channelLeave();
        signal.logout();
    }

    /**
     * Generate channel id with channel and live class id.
     */
    private String generateChannelId() {
        return "Channel" + CmsConfig.SEPARATOR_OF_ACCOUNT + this.liveClassId + CmsConfig.SUFFIX_OF_ACCOUNT;
    }

    /**
     * Generate account with live class id and user id, the account is used to register in Agora RTM system.
     * Account: User-[liveclassID]-[userId]@codyy.com
     */
    private String generateAccount() {
        return "User" + CmsConfig.SEPARATOR_OF_ACCOUNT + this.liveClassId + CmsConfig.SEPARATOR_OF_ACCOUNT
                + this.userInfo.getAttributes().getUserId() + CmsConfig.SUFFIX_OF_ACCOUNT;
    }

    /**
     * Generate next message id.
     */
    private String getNextMsgId() {
        // Generate id
        String id = this.liveClassId + "-" + this.userInfo.getAttributes().getUserId() + "-" + this.msgCount;

        // Increase message count.
        this.msgCount++;
//        this.saveMsgCount();

        return id;
    }

    /**
     * default is true
     */
    public void setLog(boolean isLoggable) {
        LoggerUtils.setIsLoggable(isLoggable);
    }

    /**
     * default is {@link com.orhanobut.logger.Logger#DEBUG}
     */
    public void setLogLevel(int logLevel) {
        LoggerUtils.setLogLevel(logLevel);
    }
}
