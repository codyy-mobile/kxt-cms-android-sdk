package com.codyy.cms.ext.textchat;

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

public class TextchatMsgModule extends AbstractMsgModule implements MessageModule {
    private String[] watchMsgNames = {
            MessagesRuleDef.TEXTCHAT_SEND_MSG.name,
            MessagesRuleDef.TEXTCHAT_DELETE_MSG.name,
            MessagesRuleDef.TEXTCHAT_DISABLE_CHAT.name,
            MessagesRuleDef.TEXTCHAT_ENABLE_CHAT.name,
            MessagesRuleDef.TEXTCHAT_ASK_QUESTION.name,
            MessagesRuleDef.TEXTCHAT_SHOW_QUESTION.name,
            MessagesRuleDef.TEXTCHAT_HIDE_QUESTION.name,
            MessagesRuleDef.TEXTCHAT_ANSWER_QUESTION.name
    };

    public TextchatMsgModule(MessageEngine messageEngine, MessageFactory messageFactory) {
        super(messageEngine, messageFactory);
    }

    @Override
    public String getType() {
        return MessageType.TEXTCHAT;
    }

    @Override
    public ArrayList<String> getWatchMsgNames() {
        return new ArrayList<>(Arrays.asList(watchMsgNames));
    }

    @Override
    public void handle(String msgName, Message message) {
        switch (msgName) {
            case MessageName.TEXTCHAT_DISABLE_CHAT:
                break;
            case MessageName.TEXTCHAT_ENABLE_CHAT:
                break;
            case MessageName.TEXTCHAT_SEND_MSG:
                break;
            case MessageName.TEXTCHAT_ASK_QUESTION:
                break;
            case MessageName.TEXTCHAT_ANSWER_QUESTION:
                break;
            case MessageName.TEXTCHAT_SHOW_QUESTION:
                break;
            case MessageName.TEXTCHAT_HIDE_QUESTION:
                break;
        }
    }
}
