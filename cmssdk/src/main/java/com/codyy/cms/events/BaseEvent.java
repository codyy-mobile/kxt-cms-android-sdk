package com.codyy.cms.events;

import io.agora.rtm.ErrorInfo;

public abstract class BaseEvent implements IMessage{
    public boolean isSuccess;
    public ErrorInfo errorInfo;

    public BaseEvent(boolean isSuccess, ErrorInfo errorInfo) {
        this.isSuccess = isSuccess;
        this.errorInfo = errorInfo;
    }

    @Override
    public String getMsg() {
        return null;
    }
}
