package com.codyy.cms.core.definition;

public class Message<T> extends BaseMessage {
    public T body;

    public Message() {
    }

    public Message(MessageHeader header) {
        super(header);
    }

    public Message(MessageHeader header, T body) {
        super(header);
        this.body = body;
    }
}
