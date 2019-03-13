package com.codyy.cms.events.cls;

import android.support.annotation.RestrictTo;

@RestrictTo(RestrictTo.Scope.LIBRARY)
public class SwitchSpeakerEvent extends SelectSpeakerEvent{
    private int oldUserId;

    public int getOldUserId() {
        return oldUserId;
    }

    public void setOldUserId(int oldUserId) {
        this.oldUserId = oldUserId;
    }
}
