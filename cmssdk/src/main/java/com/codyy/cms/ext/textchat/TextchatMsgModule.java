package com.codyy.cms.ext.textchat;

import com.codyy.cms.core.AbstractMsgModule;
import com.codyy.cms.core.MessageEngine;
import com.codyy.cms.core.MessageFactory;
import com.codyy.cms.core.MessageModule;
import com.codyy.cms.core.definition.Message;
import com.codyy.cms.core.definition.MessageName;
import com.codyy.cms.core.definition.MessageType;
import com.codyy.cms.events.textchat.TextChatDelMsgEvent;
import com.codyy.cms.events.textchat.TextChatEnabledEvent;
import com.codyy.cms.events.textchat.TextChatMsgEvent;
import com.codyy.cms.utils.EbusUtils;
import com.codyy.cms.utils.GsonUtils;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Arrays;

public class TextchatMsgModule extends AbstractMsgModule implements MessageModule {
    private String[] watchMsgNames = {
           MessageName.TEXTCHAT_SEND_MSG,
           MessageName.TEXTCHAT_DELETE_MSG,
           MessageName.TEXTCHAT_DISABLE_CHAT,
           MessageName.TEXTCHAT_ENABLE_CHAT,
           MessageName.TEXTCHAT_ASK_QUESTION,
           MessageName.TEXTCHAT_SHOW_QUESTION,
           MessageName.TEXTCHAT_HIDE_QUESTION,
           MessageName.TEXTCHAT_ANSWER_QUESTION
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
    /**
     * 讨论消息
     */
    public void sendChatMsg(String msg) {
        sendMessage(this.getMessageFactory().createChatMsg(msg));
    }
    @Override
    public void handle(String msgName, Message message) {
        switch (msgName) {
            case MessageName.TEXTCHAT_DISABLE_CHAT:
                Message<TextChatEnabledEvent> disabledEventMessage = GsonUtils.bean2Bean(message, new TypeToken<Message<TextChatEnabledEvent>>() {
                }.getType());
                disabledEventMessage.body.setEnabled(false);
                EbusUtils.post(disabledEventMessage.body);
                break;
            case MessageName.TEXTCHAT_ENABLE_CHAT:
                Message<TextChatEnabledEvent> enabledEventMessage = GsonUtils.bean2Bean(message, new TypeToken<Message<TextChatEnabledEvent>>() {
                }.getType());
                enabledEventMessage.body.setEnabled(true);
                EbusUtils.post(enabledEventMessage.body);
                break;
            case MessageName.TEXTCHAT_SEND_MSG:
                Message<TextChatMsgEvent> textChatMsgEventMessage = GsonUtils.bean2Bean(message, new TypeToken<Message<TextChatMsgEvent>>() {
                }.getType());
                textChatMsgEventMessage.body.setMsgId(message.header.id);
                EbusUtils.post(textChatMsgEventMessage.body);
                break;
            case MessageName.TEXTCHAT_DELETE_MSG:
                Message<TextChatDelMsgEvent> textChatDelMsgEventMessage = GsonUtils.bean2Bean(message, new TypeToken<Message<TextChatDelMsgEvent>>() {
                }.getType());
                EbusUtils.post(textChatDelMsgEventMessage.body);
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
