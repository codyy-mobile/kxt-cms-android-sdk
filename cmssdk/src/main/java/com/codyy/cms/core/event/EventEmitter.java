package com.codyy.cms.core.event;

import com.codyy.cms.core.MessageHandler;
import com.codyy.cms.core.definition.Message;

import java.util.HashMap;

public class EventEmitter {
    private HashMap<String, MessageHandler> maps = new HashMap<>();

    public void on(String eventName, MessageHandler messageHandler) {
        maps.put(eventName, messageHandler);
    }

    public void addListener(String eventName, MessageHandler messageHandler) {
        maps.put(eventName, messageHandler);
    }

    public void emit(String eventName, Message message) {
        if (maps.containsKey(eventName)) {
            maps.get(eventName).handle(eventName, message);
        }
    }
}
