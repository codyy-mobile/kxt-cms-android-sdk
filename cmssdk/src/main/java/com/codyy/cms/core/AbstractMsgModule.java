package com.codyy.cms.core;

import com.codyy.cms.core.definition.Message;
import com.codyy.cms.core.event.EventEmitter;

public abstract class AbstractMsgModule extends EventEmitter implements MessageModule {
    protected MessageEngine messageEngine;
    protected MessageFactory messageFactory;

    public AbstractMsgModule(MessageEngine messageEngine, MessageFactory messageFactory) {
        this.messageEngine = messageEngine;
        this.messageFactory = messageFactory;
    }


    public MessageEngine getMessageEngine() {
        return messageEngine;
    }

    public MessageFactory getMessageFactory() {
        return messageFactory;
    }

    public void sendMessage(Message message) {
        try {
            if (message != null) {
                this.messageEngine.sendMessage(message);
            } else {
                throw new NullPointerException("send message can not be null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
