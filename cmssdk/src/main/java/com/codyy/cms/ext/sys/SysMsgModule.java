package com.codyy.cms.ext.sys;

import com.codyy.cms.core.AbstractMsgModule;
import com.codyy.cms.core.MessageEngine;
import com.codyy.cms.core.MessageFactory;
import com.codyy.cms.core.MessageModule;
import com.codyy.cms.core.definition.Message;
import com.codyy.cms.core.definition.MessageName;
import com.codyy.cms.core.definition.MessageType;
import com.codyy.cms.core.definition.MessagesRuleDef;

import java.util.ArrayList;
import java.util.Arrays;

public class SysMsgModule extends AbstractMsgModule implements MessageModule {
    private String[] watchMsgNames = {
            MessagesRuleDef.SYS_CAPTURE_SCREEN.name,
            MessagesRuleDef.SYS_CAPTURE_SCREEN_URL.name,
            MessagesRuleDef.SYS_SWITCH_APP.name,
            MessagesRuleDef.SYS_LOCK_KEYBOARD.name
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

    @Override
    public void handle(String msgName, Message message) {
        switch (msgName) {
            case MessageName.SYS_LOCK_KEYBOARD:
                break;
            case MessageName.SYS_CAPTURE_SCREEN:
                break;
            case MessageName.SYS_CAPTURE_SCREEN_URL:
                break;
            case MessageName.SYS_SWITCH_APP:
                break;
        }
    }
}
