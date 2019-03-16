package com.codyy.cms.ext.sys;

import com.codyy.cms.core.AbstractMsgModule;
import com.codyy.cms.core.MessageEngine;
import com.codyy.cms.core.MessageFactory;
import com.codyy.cms.core.MessageModule;
import com.codyy.cms.core.definition.AppActive;
import com.codyy.cms.core.definition.Message;
import com.codyy.cms.core.definition.MessageName;
import com.codyy.cms.core.definition.MessageType;
import com.codyy.cms.events.sys.CaptureScreenEvent;
import com.codyy.cms.utils.EbusUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class SysMsgModule extends AbstractMsgModule implements MessageModule {
    private String[] watchMsgNames = {
            MessageName.SYS_CAPTURE_SCREEN
    };

    public SysMsgModule(MessageEngine messageEngine, MessageFactory messageFactory) {
        super(messageEngine, messageFactory);
    }

    @Override
    public String getType() {
        return MessageType.SYS;
    }

    @Override
    public ArrayList<String> getWatchMsgNames() {
        return new ArrayList<>(Arrays.asList(watchMsgNames));
    }

    /**
     * 发送截屏图片地址
     */
    public void sendCaptureScreenUrlMsg(String originalMsgId, String imageUrl) {
        sendMessage(this.getMessageFactory().createCaptureScreenUrlMsg(originalMsgId, imageUrl));
    }

    /**
     * 认真度通知
     */
    public void sendAppSwitchedMsg(@AppActive String action, int activeDuration, int inactiveDuration) {
        sendMessage(this.getMessageFactory().createSwitchAppMsg(action, activeDuration, inactiveDuration));
    }

    @Override
    public void handle(String msgName, Message message) {
        switch (msgName) {
            case MessageName.SYS_CAPTURE_SCREEN://消息名称：sys_capture_screen(教师或助教发起)
                for (int userId : message.header.targetUserIds) {
                    //功能：通过信令消息通知所有人，收到后检查msg header里的receiverAccounts字段，如果包含自己则执行截图操作，否则忽略此消息
                    if (getMessageEngine().getCmsEngine().getUserMsgModule().getMe().attributes.userId == userId) {
                        EbusUtils.post(new CaptureScreenEvent(message.header.id));
                    }
                }
                break;
        }
    }
}
