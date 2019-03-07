package com.codyy.cms.core.definition;

public class Message {
    public MessageHeader header;
    public MessageBody body;

    public Message() {
    }

    public Message(MessageHeader header, MessageBody body) {
        this.header = header;
        this.body = body;
    }

}
