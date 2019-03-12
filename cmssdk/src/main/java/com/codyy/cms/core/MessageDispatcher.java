package com.codyy.cms.core;

import com.codyy.cms.core.definition.Message;
import com.codyy.cms.core.event.EventEmitter;

/**
 * 负责处理消息的订阅和分发。
 */
public class MessageDispatcher extends EventEmitter {
    /**
     * Dispatch message.
     */
    public void dispatch(Message message) {
        this.emit(message.header.name, message);
    }

    /**
     * Subscribe messages which are concerned by specified message module.
     */
    public void subscribe(MessageModule msgModule) {
        for (String msgName : msgModule.getWatchMsgNames()) {
            this.addListener(msgName, msgModule);
        }
    }

    /**
     * Unsubscribe messages which are concerned by specified message module.
     *
     * @param msgModule
     */
    public void unsubscribe(MessageModule msgModule) {
        for (String msgName : msgModule.getWatchMsgNames()) {
            this.removeListener(msgName);
        }
    }

    /**
     * Subscribe specified message.
     */
    public void subscribeMessage(String msgName, MessageHandler msgListener) {
        this.addListener(msgName, msgListener);
    }

    /**
     * Unsubscribe specified message.
     *
     * @param {string}         msgName
     * @param {MessageHandler} msgListener
     * @memberof MessageDispatcher
     */
    public void unsubscribeMessage(String msgName) {
        this.removeListener(msgName);
    }

    public void unsubscribeAll() {
        this.clear();
    }
}
