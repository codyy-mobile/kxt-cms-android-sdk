package com.codyy.cms.events.cls;

import org.json.JSONObject;

/**
 * 测验讲解（已取消，功能合并到结束测验消息class_end_testing)
 */
@Deprecated
public class EndExplainTestingEvent {
    public JSONObject object;

    public EndExplainTestingEvent(JSONObject object) {
        this.object = object;
    }
}
