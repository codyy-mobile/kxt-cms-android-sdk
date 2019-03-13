package com.codyy.cms.events.whiteboard;

import org.json.JSONObject;

public class WhiteBoardEvent {
    private JSONObject wb;

    public WhiteBoardEvent(JSONObject wb) {
        this.wb = wb;
    }

    public JSONObject getWb() {
        return wb;
    }

    public void setWb(JSONObject wb) {
        this.wb = wb;
    }
}
