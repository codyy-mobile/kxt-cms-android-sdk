package com.codyy.cms.ext.cls;

import com.codyy.cms.core.AbstractMsgModule;
import com.codyy.cms.core.MessageEngine;
import com.codyy.cms.core.MessageFactory;
import com.codyy.cms.core.MessageModule;
import com.codyy.cms.core.definition.Message;
import com.codyy.cms.core.definition.MessageType;
import com.codyy.cms.core.definition.MessagesRuleDef;

import java.util.ArrayList;
import java.util.Arrays;

public class ClassMsgModule extends AbstractMsgModule implements MessageModule {
    private String[] watchMsgNames= {
            MessagesRuleDef.CLASS_START_WARMINGUP.name,
            MessagesRuleDef.CLASS_STOP_WARMINGUP.name,
            MessagesRuleDef.CLASS_START.name,
            MessagesRuleDef.CLASS_END.name,
            MessagesRuleDef.CLASS_START_SIGNIN.name,
            MessagesRuleDef.CLASS_END_SIGNIN.name,
            MessagesRuleDef.CLASS_CLEAR_ALL_HAND_UP.name,
            MessagesRuleDef.CLASS_SELECT_SPEAKER.name,
            MessagesRuleDef.CLASS_END_SPEAKING.name,
            MessagesRuleDef.CLASS_SWITCH_SPEAKER.name,
            MessagesRuleDef.CLASS_BEGIN_TESTING.name,
            MessagesRuleDef.CLASS_END_TESTING.name,
            MessagesRuleDef.CLASS_EXPLAIN_TESTING.name,
            MessagesRuleDef.CLASS_EXIT_EXPLAINING_TEST.name,
            MessagesRuleDef.CLASS_BEGIN_TESTCARD.name,
            MessagesRuleDef.CLASS_END_TESTCARD.name,
            MessagesRuleDef.CLASS_TESTCARD_RESULT.name,
            MessagesRuleDef.CLASS_START_SHARING_DESKTOP.name,
            MessagesRuleDef.CLASS_STOP_SHARING_DESKTOP.name,
            MessagesRuleDef.CLASS_ADJUST_VIDEO.name,
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

    @Override
    public void handle(String msgName, Message message) {

    }
}
