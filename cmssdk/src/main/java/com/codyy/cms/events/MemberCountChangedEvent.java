package com.codyy.cms.events;

public class MemberCountChangedEvent {
    public int count;

    public MemberCountChangedEvent(int count) {
        this.count = count;
    }
}
