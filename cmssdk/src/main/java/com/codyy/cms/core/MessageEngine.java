package com.codyy.cms.core;

import android.text.TextUtils;
import android.util.SparseArray;

import com.codyy.cms.core.definition.Message;
import com.codyy.cms.core.definition.MessageHeader;
import com.codyy.cms.core.definition.MessagesRuleDef;
import com.codyy.cms.core.definition.MsgSendType;
import com.codyy.cms.utils.CombineUtils;
import com.codyy.cms.utils.GsonUtils;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

import org.jdeferred2.Deferred;
import org.jdeferred2.Promise;
import org.jdeferred2.impl.DeferredObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import io.agora.rtm.ErrorInfo;
import io.agora.rtm.IResultCallback;
import io.agora.rtm.RtmChannel;
import io.agora.rtm.RtmChannelListener;
import io.agora.rtm.RtmChannelMember;
import io.agora.rtm.RtmMessage;
import io.agora.rtm.RtmStatusCode;

import static com.codyy.cms.agora.RtmStatusCode.JoinChannelError.JOIN_CHANNEL_ERR_OK;

public class MessageEngine {
    private CmsEngine cmsEngine;

    /**
     * 加入的声网通道（组）
     *
     * @private
     * @type {string}
     * @memberof MessageEngine
     */
    private String channelId;
    /**
     * 声网sdk channel实例
     */
    private RtmChannel rtmChannel;
    private MsgEngineOpts options;

    private int msgCount = 0;
    /**
     * 阔学堂用户Id到声网用户账号的映射字典。
     *
     * @private
     * @type {Map<number, string>}
     * @memberof MessageEngine
     */
    private SparseArray<String> userIdMap;

    /**
     * 声网用户账号到阔学堂用户Id的映射字典。
     *
     * @private
     * @type {Map<string, number>}
     * @memberof MessageEngine
     */
    private Map<String, Integer> accountMap;
    private LinkedList<String> memberJoinPendingList;

    private LinkedList<String> memberLeftPendingList;
    /**
     * 线程安全
     */
    private AtomicInteger mChannelMemberCount = new AtomicInteger(0);

    public MessageEngine(CmsEngine cmsEngine, String channelId, MsgEngineOpts options) {
        this.accountMap = new HashMap<>();
        this.userIdMap = new SparseArray<>();
        this.memberJoinPendingList = new LinkedList<>();
        this.memberLeftPendingList = new LinkedList<>();
        this.cmsEngine = cmsEngine;
        this.channelId = channelId;
        this.options = options;
        rtmChannel = cmsEngine.getRtmClient().createChannel(this.channelId, new RtmChannelListener() {
            @Override
            public void onMessageReceived(RtmMessage message, RtmChannelMember fromMember) {
                try {
                    onMessage(fromMember.getUserId(), message);
                } catch (CmsException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onMemberJoined(RtmChannelMember member) {
                mChannelMemberCount.incrementAndGet();
                refreshMemberCount();
            }

            @Override
            public void onMemberLeft(RtmChannelMember member) {
                mChannelMemberCount.decrementAndGet();
                Integer userId = accountMap.get(member.getUserId());
                if (userId != null && userId >= 0) {
                    userIdMap.remove(userId);
                    accountMap.remove(member.getUserId());
                }
                refreshMemberCount();
            }

            @Override
            public void onAttributesUpdated(Map<String, String> attributes) {

            }

            @Override
            public void onAttributesDeleted(Map<String, String> attributes) {

            }
        });
    }

    /**
     * Send message by Agora RTM sdk.
     *
     * @param {Message} message
     * @throws {CmsException}
     * @returns {Promise<MessageResult>}
     * @memberof MessageEngine
     */
    public void sendMessage(Message message) throws CmsException {
        MessageHeader header = message.header;
        this.validateMsg(message);
        header.id = this.getNextMsgId();
        header.channelId = this.channelId;
        if (header.userId == 0) {
            header.userId = this.options.userId;
        }
        if (header.targetUserIds != null && header.targetUserIds.size() > 30 && MsgSendType.CP2M.equals(header.sendType)) {
            throw new CmsException(CmsException.CmsErrorCode.MSG_TARGETS_OUT_OF_LIMIT, "Size of targetUserIds(" + header.targetUserIds.size() + ") is out of limit.");
        }
        Logger.i("[Sent sender=" + header.userId + ", msg=" + header.name + " ]: " + new Gson().toJson(message));
        if (MsgSendType.CP2M.equals(header.sendType)) {
            if (header.targetUserIds.size() == 1) {
                Message msg = (Message) CombineUtils.combineSydwCore(message, new Message());
                msg.header.targetUserIds = new ArrayList<>();
                msg.header.targetUserIds.add(header.targetUserIds.get(0));
                msg.header.timestamp = System.currentTimeMillis();
                RtmMessage sendMsg = RtmMessage.createMessage();
                sendMsg.setText(new Gson().toJson(message));
                cmsEngine.getRtmClient().sendMessageToPeer(userIdMap.get(header.targetUserIds.get(0)), sendMsg, state -> {
//                    Logger.i("sendMessageToPeer", state);
                });
            } else {
                for (int i : header.targetUserIds) {
                    Message msg = (Message) CombineUtils.combineSydwCore(message, new Message());
                    msg.header.targetUserIds = new ArrayList<>();
                    msg.header.targetUserIds.add(header.targetUserIds.get(i));
                    msg.header.timestamp = System.currentTimeMillis();
                    RtmMessage sendMsg = RtmMessage.createMessage();
                    sendMsg.setText(new Gson().toJson(message));
                    cmsEngine.getRtmClient().sendMessageToPeer(userIdMap.get(header.targetUserIds.get(0)), sendMsg, state -> {
//                        Logger.i("sendMessageToPeer", state);
                    });
                }
            }

        } else {
            message.header.timestamp = System.currentTimeMillis();
            RtmMessage sendMsg = RtmMessage.createMessage();
            sendMsg.setText(new Gson().toJson(message));
            rtmChannel.sendMessage(sendMsg, newState -> {
//                Logger.i("sendMessageToPeer"+ newState+ sendMsg.getText());
                // See RtmStatusCode.ChannelMessageState for the message states.
//                switch (newState) {
//                    case RtmStatusCode.ChannelMessageState.CHANNEL_MESSAGE_SENT_TIMEOUT:
//                    case RtmStatusCode.ChannelMessageState.CHANNEL_MESSAGE_FAILURE:
////                    showToast(getString(R.string.send_msg_failed));
//                        break;
//                }
            });
        }
    }

    /**
     * Receive message from Agora RTM sdk.
     *
     * @param peerId
     * @param msg
     */
    void onMessage(String peerId, RtmMessage msg) throws CmsException {
        Message message = GsonUtils.json2Bean(msg.getText(), Message.class);
        message.header.rtmAccount = peerId;
        Logger.i("[Received receiver=" + this.cmsEngine.getUserMsgModule().getMe().attributes.userId + ", msg=" + message.header.name + " ] " + GsonUtils.bean2JsonStr(message));
        Integer accountUserId = accountMap.get(peerId);
        if (accountUserId != null && (this.cmsEngine.getUserMsgModule().getMe().attributes.userId == accountUserId)) {
            // 收到的是自己发送的广播消息，忽略。
            Logger.w("Received message which is sent by self. " + "rtmAccount: " + peerId + " Message: " + msg.getText());
            return;
        }
        validateMsg(message);
        if (MessagesRuleDef.USER_INFO.name.equals(message.header.name)) {
            this.setUserIdAccoutnMap(message.header.userId, peerId);
        }

        this.options.cmsEngine.getMsgDispatcher().dispatch(message);
    }

    /**
     * Generate next message id.
     */
    private String getNextMsgId() {
        // Generate id
        String id = this.options.liveClassId + "-" + this.options.userId + "-" + this.msgCount;

        // Increase message count.
        this.msgCount++;
        this.saveMsgCount();

        return id;
    }

    /**
     * Save message count to local storage.
     *
     * @private
     * @memberof MessageEngine
     */
    private void saveMsgCount() {
        // TODO...
    }

    /**
     * API CALL: get channel member list
     */
    private void getChannelMemberList() {
        rtmChannel.getMembers(new IResultCallback<List<RtmChannelMember>>() {
            @Override
            public void onSuccess(List<RtmChannelMember> rtmChannelMembers) {
                mChannelMemberCount = new AtomicInteger(rtmChannelMembers.size());
            }

            @Override
            public void onFailure(ErrorInfo errorInfo) {
                Logger.e("failed to get channel members, err: " + errorInfo.getErrorCode());
            }
        });
    }

    /**
     * 刷新在线人数
     */
    private void refreshMemberCount() {
        if (memberCountListener != null) {
            memberCountListener.refresh(mChannelMemberCount.intValue());
        }
    }

    private MemberCountListener memberCountListener;

    public void setMemberCountListener(MemberCountListener memberCountListener) {
        this.memberCountListener = memberCountListener;
    }

    public interface MemberCountListener {
        void refresh(int count);
    }

    /**
     * 发送频道消息
     * 在成功加入频道之后，用户可以开始向该频道发送消息。
     * 调用 RtmChannel 实例的 sendMessage 方法向该频道发送消息。在该方法中：
     * <u>
     * <li>
     * 传入 RtmMessage 对象实例。该消息对象由 RtmMessage 类的 createMessage 静态方法创建，并使用消息实例的 setText 方法设置消息内容。
     * </li>
     * <li>
     * 传入消息发送状态监听器，用于接收消息发送结果回调，如：服务器已接收，发送超时等。
     * </li>
     * </u>
     * {@link io.agora.rtm.RtmStatusCode.ChannelMessageState}
     */
    public void sendChannelMessage(String msg) {
        RtmMessage message = RtmMessage.createMessage();
        message.setText(msg);
        rtmChannel.sendMessage(message, newState -> {
            // See RtmStatusCode.ChannelMessageState for the message states.
            switch (newState) {
                case RtmStatusCode.ChannelMessageState.CHANNEL_MESSAGE_SENT_TIMEOUT:
                case RtmStatusCode.ChannelMessageState.CHANNEL_MESSAGE_FAILURE:
//                    showToast(getString(R.string.send_msg_failed));
                    break;
            }
        });
    }

    public Promise<Integer, Throwable, Void> joinChannel2() {
        Deferred<Integer, Throwable, Void> deferred = new DeferredObject<>();
        if (rtmChannel != null) {
            rtmChannel.join(new IResultCallback<Void>() {
                @Override
                public void onSuccess(Void responseInfo) {
                    // Join a channel succeeds.
                    // 设置用户id和信令账号
                    setUserIdAccoutnMap(cmsEngine.getUserMsgModule().getMe().attributes.userId, cmsEngine.getRtmAccount());
                    // 用户加入频道后立即发送广播消息通知频道内所有用户更新用户信息。
                    try {
                        cmsEngine.getUserMsgModule().sendUserInfoMsg();
                    } catch (CmsException e) {
                        e.printStackTrace();
                        deferred.reject(e);
                    } finally {
                        deferred.resolve(JOIN_CHANNEL_ERR_OK);
                    }
                }

                @Override
                public void onFailure(ErrorInfo errorInfo) {
                    int errorCode = errorInfo.getErrorCode();
                    deferred.reject(new CmsException(errorCode, ""));
                    // Join a channel fails. See the error codes defined in RtmStatusCode.JoinChannelError.
                }
            });
        }
        return deferred.promise();
    }


    /**
     * 调用 RtmChannel 实例的 leave 方法可以退出该频道。退出频道之后可以调用 join 方法再重新加入频道。
     */
    public Promise<Integer, Throwable, Void> channelLeave() {
        Deferred<Integer, Throwable, Void> deferred = new DeferredObject<>();
        if (rtmChannel != null) {
            rtmChannel.leave(new IResultCallback<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    deferred.resolve(0);
                    rtmChannel.release();
                    rtmChannel = null;
                }

                @Override
                public void onFailure(ErrorInfo errorInfo) {
                    deferred.reject(new CmsException(errorInfo.getErrorCode(),"leave channel failure"));
                }
            });

        }
        return deferred.promise();
    }

    /**
     * 设置用户id的map
     *
     * @param {number} userId
     * @param {string} memberId
     * @memberof MessageEngine
     */
    public void setUserIdAccoutnMap(int userId, String memberId) {
        this.userIdMap.put(userId, memberId);
        this.accountMap.put(memberId, userId);
    }

    /**
     * 加密消息
     *
     * @param {string} plain
     * @private
     * @returns {string}
     * @memberof MessageEngine
     */
    private String encryptMsg(String plain) {
        // TODO ...
        return plain;
        // return Buffer.from(plain).toString('base64');
    }

    /**
     * 解密消息
     *
     * @param {string} ciphertext
     * @private
     * @returns {string}
     * @memberof MessageEngine
     */
    private String decryptMsg(String ciphertext) {
        // TODO ...
        return ciphertext;
        // return Buffer.from(ciphertext, "base64").toString('utf8');
    }

    /**
     * Validate message fields.
     *
     * @param {Message} message
     * @private
     * @memberof MessageEngine
     */
    private void validateMsg(Message message) throws CmsException {
        if (message.header == null) {
            throw new CmsException(CmsException.CmsErrorCode.MSG_NO_HEADER, "Message header is null.");
        }

        MessageHeader header = message.header;
        if (TextUtils.isEmpty(header.getName())) {
            throw new CmsException(CmsException.CmsErrorCode.MSG_NO_NAME, "Message name is not set.");
        }

        if (TextUtils.isEmpty(header.getType())) {
            throw new CmsException(CmsException.CmsErrorCode.MSG_NO_TYPE, "Message type is not set.");
        }

        if (TextUtils.isEmpty(header.getSendType())) {
            throw new CmsException(CmsException.CmsErrorCode.MSG_NO_SENDTYPE, "Message sendType is not set.");
        }
    }
}
