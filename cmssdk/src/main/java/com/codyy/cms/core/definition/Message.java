package com.codyy.cms.core.definition;

public class Message<T> {
    public MessageHeader header;
    public T body;

    public Message() {
    }

    public Message(MessageHeader header, T body) {
        this.header = header;
        this.body = body;
    }
}
