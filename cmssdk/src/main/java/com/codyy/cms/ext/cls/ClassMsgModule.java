package com.codyy.cms.ext.cls;

import com.codyy.cms.core.AbstractMsgModule;
import com.codyy.cms.core.MessageEngine;
import com.codyy.cms.core.MessageFactory;
import com.codyy.cms.core.MessageModule;
import com.codyy.cms.core.definition.Message;
import com.codyy.cms.core.definition.MessageName;
import com.codyy.cms.core.definition.MessageType;
import com.codyy.cms.events.cls.AdjustVideoEvent;
import com.codyy.cms.events.cls.BeginTestingEvent;
import com.codyy.cms.events.cls.ClearAllHandUpEvent;
import com.codyy.cms.events.cls.ClsEndEvent;
import com.codyy.cms.events.cls.ClsStartEvent;
import com.codyy.cms.events.cls.EndSigninEvent;
import com.codyy.cms.events.cls.EndSpeakingEvent;
import com.codyy.cms.events.cls.EndTestingEvent;
import com.codyy.cms.events.cls.ExitTestingEvent;
import com.codyy.cms.events.cls.ExplainTestingEvent;
import com.codyy.cms.events.cls.RestoreSpeakingEvent;
import com.codyy.cms.events.cls.SelectSpeakerEvent;
import com.codyy.cms.events.cls.SharingDesktopEvent;
import com.codyy.cms.events.cls.StartSigninEvent;
import com.codyy.cms.events.cls.StartWarmupEvent;
import com.codyy.cms.events.cls.StopWarmupEvent;
import com.codyy.cms.events.cls.SwitchSpeakerEvent;
import com.codyy.cms.utils.EbusUtils;
import com.codyy.cms.utils.GsonUtils;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Arrays;


public class ClassMsgModule extends AbstractMsgModule implements MessageModule {
    private String[] watchMsgNames = {
            MessageName.CLASS_START_WARMINGUP,
            MessageName.CLASS_STOP_WARMINGUP,
            MessageName.CLASS_START,
            MessageName.CLASS_END,
            MessageName.CLASS_START_SIGNIN,
            MessageName.CLASS_END_SIGNIN,
            MessageName.CLASS_CLEAR_ALL_HAND_UP,
            MessageName.CLASS_SELECT_SPEAKER,
            MessageName.CLASS_END_SPEAKING,
            MessageName.CLASS_SWITCH_SPEAKER,
            MessageName.CLASS_RESTORE_SPEAKING,
            MessageName.CLASS_EXPLAIN_TESTING,
            MessageName.CLASS_BEGIN_TESTING,
            MessageName.CLASS_END_TESTING,
            MessageName.CLASS_EXIT_TESTING,
            MessageName.CLASS_TESTCARD_RESULT,
            MessageName.CLASS_START_SHARING_DESKTOP,
            MessageName.CLASS_STOP_SHARING_DESKTOP,
            MessageName.CLASS_ADJUST_VIDEO,
    };

    public ClassMsgModule(MessageEngine messageEngine, MessageFactory messageFactory) {
        super(messageEngine, messageFactory);
    }

    @Override
    public String getType() {
        return MessageType.CLASS;
    }

    @Override
    public ArrayList<String> getWatchMsgNames() {
        return new ArrayList<>(Arrays.asList(watchMsgNames));
    }

    /**
     * 点名-签到
     */
    public void sendSignInMsg() {
        sendMessage(getMessageFactory().createSignInMsg());
    }

    /**
     * 举手发言
     */
    public void sendHandingUpMsg() {
        sendMessage(getMessageFactory().createHandUpMsg());
    }

    /**
     * 取消举手
     */
    public void sendCancelHandingUpMsg() {
        sendMessage(getMessageFactory().createCancelHandUpMsg());
    }

    /**
     * 结束发言
     */
    public void sendEndSpeakingMsg() {
        sendMessage(getMessageFactory().createEndSpeakerMsg());
    }

    /**
     * 发送视频码率
     *
     * @param videoRate 视频码率
     */
    public void sendNotifyVideoRateMsg(int videoRate) {
        sendMessage(getMessageFactory().createNotifyVideoRateMsg(videoRate));
    }

    /**
     * 学员提交试卷
     */
    public void sendSubmitTestingMsg(int testId, int classTestId) {
        sendMessage(getMessageFactory().createSubmitTestingMsg(testId, classTestId));
    }

    @Override
    public void handle(String msgName, Message message) {
        switch (msgName) {
            case MessageName.CLASS_START_WARMINGUP:
                Message<StartWarmupEvent> startWarmupEventMessage = GsonUtils.bean2Bean(message, new TypeToken<Message<StartWarmupEvent>>() {
                }.getType());
                EbusUtils.post(startWarmupEventMessage.body);
                break;
            case MessageName.CLASS_STOP_WARMINGUP:
                EbusUtils.post(new StopWarmupEvent());
                break;
            case MessageName.CLASS_START:
                EbusUtils.post(new ClsStartEvent());
                break;
            case MessageName.CLASS_END:
                EbusUtils.post(new ClsEndEvent());
                break;
            case MessageName.CLASS_START_SIGNIN:
                Message<StartSigninEvent> startSigninEventMessage = GsonUtils.bean2Bean(message, new TypeToken<Message<StartSigninEvent>>() {
                }.getType());
                EbusUtils.post(startSigninEventMessage.body);
                break;
            case MessageName.CLASS_END_SIGNIN:
                Message<EndSigninEvent> endSigninEventMessage = GsonUtils.bean2Bean(message, new TypeToken<Message<EndSigninEvent>>() {
                }.getType());
                EbusUtils.post(endSigninEventMessage.body);
                break;
            case MessageName.CLASS_CLEAR_ALL_HAND_UP:
                EbusUtils.post(new ClearAllHandUpEvent());
                break;
            case MessageName.CLASS_SELECT_SPEAKER:
                Message<SelectSpeakerEvent> speakerEventMessage = GsonUtils.bean2Bean(message, new TypeToken<Message<SelectSpeakerEvent>>() {
                }.getType());
                speakerEventMessage.body.isSelf = speakerEventMessage.body.getUserId() == getMessageEngine().getCmsEngine().getUserMsgModule().getMe().attributes.userId;
                EbusUtils.post(speakerEventMessage.body);
                break;
            case MessageName.CLASS_END_SPEAKING:
                Message<EndSpeakingEvent> endSpeakingEvent = GsonUtils.bean2Bean(message, new TypeToken<Message<EndSpeakingEvent>>() {
                }.getType());
                endSpeakingEvent.body.isSelf = endSpeakingEvent.body.getUserId() == getMessageEngine().getCmsEngine().getUserMsgModule().getMe().attributes.userId;
                EbusUtils.post(endSpeakingEvent.body);
                break;
            case MessageName.CLASS_SWITCH_SPEAKER:
                Message<SwitchSpeakerEvent> switchSpeakerEventMessage = GsonUtils.bean2Bean(message, new TypeToken<Message<SwitchSpeakerEvent>>() {
                }.getType());
                if (switchSpeakerEventMessage.body.getUserId() == getMessageEngine().getCmsEngine().getUserMsgModule().getMe().attributes.userId) {
                    switchSpeakerEventMessage.body.isSelf = true;//如果切换发言切换到自己，则处理指定发言的流程；
                    EbusUtils.post(switchSpeakerEventMessage.body);
                } else {
                    //do nothing
                }
                break;
            case MessageName.CLASS_RESTORE_SPEAKING:
                for (int userId : message.header.targetUserIds) {
                    if (userId == getMessageEngine().getCmsEngine().getUserMsgModule().getMe().attributes.userId) {//当处于连麦状态下，教师页面刷新后发消息给发言人恢复连麦
                        // header.targetUserIds里填写发言人userId
                        EbusUtils.post(new RestoreSpeakingEvent());
                    }
                }
                break;
            case MessageName.CLASS_BEGIN_TESTING:
                Message<BeginTestingEvent> beginTestingEventMessage = GsonUtils.bean2Bean(message, new TypeToken<Message<BeginTestingEvent>>() {
                }.getType());
                EbusUtils.post(beginTestingEventMessage.body);
                break;
            case MessageName.CLASS_END_TESTING:
                Message<EndTestingEvent> endTestingEventMessage = GsonUtils.bean2Bean(message, new TypeToken<Message<EndTestingEvent>>() {
                }.getType());
                EbusUtils.post(endTestingEventMessage.body);
                break;
            case MessageName.CLASS_EXIT_TESTING:
                Message<ExitTestingEvent> exitTestingEventMessage = GsonUtils.bean2Bean(message, new TypeToken<Message<ExitTestingEvent>>() {
                }.getType());
                EbusUtils.post(exitTestingEventMessage.body);
                break;
            case MessageName.CLASS_EXPLAIN_TESTING:
                Message<ExplainTestingEvent> explainTestingEventMessage = GsonUtils.bean2Bean(message, new TypeToken<Message<ExplainTestingEvent>>() {
                }.getType());
                EbusUtils.post(explainTestingEventMessage.body);
                break;
            case MessageName.CLASS_START_SHARING_DESKTOP:
                Message<SharingDesktopEvent> sharingDesktopEventMessage = GsonUtils.bean2Bean(message, new TypeToken<Message<SharingDesktopEvent>>() {
                }.getType());
                sharingDesktopEventMessage.body.setSharing(true);
                EbusUtils.post(sharingDesktopEventMessage.body);
                break;
            case MessageName.CLASS_STOP_SHARING_DESKTOP:
                EbusUtils.post(new SharingDesktopEvent(false, null));
                break;
            case MessageName.CLASS_ADJUST_VIDEO:
                Message<AdjustVideoEvent> adjustVideoEventMessage = GsonUtils.bean2Bean(message, new TypeToken<Message<AdjustVideoEvent>>() {
                }.getType());
                EbusUtils.post(adjustVideoEventMessage.body);
                break;


        }
    }
}
