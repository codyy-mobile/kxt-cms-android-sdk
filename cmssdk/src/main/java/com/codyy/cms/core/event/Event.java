package com.codyy.cms.core.event;

import com.codyy.cms.core.MessageHandler;

/**
 * Used HashMap instead of this class
 */
@Deprecated
public class Event {
    private String eventName;
    private MessageHandler eventHandler;

    public Event(String eventName, MessageHandler eventHandler) {
        this.eventName = eventName;
        this.eventHandler = eventHandler;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public MessageHandler getEventHandler() {
        return eventHandler;
    }

    public void setEventHandler(MessageHandler eventHandler) {
        this.eventHandler = eventHandler;
    }
}
