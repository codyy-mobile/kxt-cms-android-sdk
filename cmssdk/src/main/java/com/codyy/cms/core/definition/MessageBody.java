package com.codyy.cms.core.definition;

public class MessageBody<T> {
    private T object;

    public MessageBody(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
