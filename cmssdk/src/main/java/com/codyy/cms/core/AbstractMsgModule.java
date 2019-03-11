package com.codyy.cms.core;

import com.codyy.cms.core.definition.Message;
import com.codyy.cms.core.event.EventEmitter;

public abstract class AbstractMsgModule extends EventEmitter implements MessageModule {
    protected MessageEngine messageEngine;
    protected MessageFactory messageFactory;

    public AbstractMsgModule(MessageEngine messageEngine, MessageFactory messageFactory) {
        this.messageEngine = messageEngine;
        this.messageFactory = messageFactory;
        this.init();
    }

    protected void init() {
        this.load();
    }

    public MessageEngine getMessageEngine() {
        return messageEngine;
    }

    public MessageFactory getMessageFactory() {
        return messageFactory;
    }

    public void sendMessage(Message message) throws CmsException {
        this.messageEngine.sendMessage(message);
    }

    @Override
    public void load() {

    }

    @Override
    public void save() {

    }

    /**
     * 销毁对象释放资源
     *
     * @memberof AbstractMsgModule
     */
    void destory() {
        this.save();
    }
}
