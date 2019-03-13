package com.codyy.cms.events;

import android.support.annotation.RestrictTo;

import io.agora.rtm.ErrorInfo;
@RestrictTo(RestrictTo.Scope.LIBRARY)
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
