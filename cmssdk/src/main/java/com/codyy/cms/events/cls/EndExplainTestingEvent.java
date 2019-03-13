package com.codyy.cms.events.cls;

import org.json.JSONObject;

public class EndExplainTestingEvent {
    public JSONObject object;

    public EndExplainTestingEvent(JSONObject object) {
        this.object = object;
    }
}
