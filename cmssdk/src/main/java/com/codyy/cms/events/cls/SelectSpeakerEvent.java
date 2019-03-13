package com.codyy.cms.events.cls;

public class SelectSpeakerEvent {
    private int userId;
    /**
     * {@link com.codyy.cms.core.definition.SpeakingMethod}
     */
    private String method;

    public int getUserId() {
        return userId;
    }

    public String getMethod() {
        return method;
    }

    public boolean isSelf;
}
