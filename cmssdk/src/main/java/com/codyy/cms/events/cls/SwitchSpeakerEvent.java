package com.codyy.cms.events.cls;

public class SwitchSpeakerEvent extends SelectSpeakerEvent{
    private int oldUserId;

    public int getOldUserId() {
        return oldUserId;
    }

    public void setOldUserId(int oldUserId) {
        this.oldUserId = oldUserId;
    }
}
