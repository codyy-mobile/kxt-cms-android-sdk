package com.codyy.cms.events.sys;

public class CaptureScreenEvent {
    private String originalMsgId;

    public CaptureScreenEvent(String originalMsgId) {
        this.originalMsgId = originalMsgId;
    }

    public String getOriginalMsgId() {
        return originalMsgId;
    }

    public void setOriginalMsgId(String originalMsgId) {
        this.originalMsgId = originalMsgId;
    }
}
