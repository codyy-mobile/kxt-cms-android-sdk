package com.codyy.cms.core.definition;

public class MessageBody {
    private Object object;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public MessageBody(Object object) {
        this.object = object;
    }
}
