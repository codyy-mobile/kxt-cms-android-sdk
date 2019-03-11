package com.codyy.cms.core;

import io.agora.rtm.RtmClient;

public class MsgEngineOpts {
    public CmsEngine cmsEngine;
    public RtmClient rtmClient;
    public int liveClassId;
    public int userId;

    public MsgEngineOpts(CmsEngine cmsEngine, RtmClient rtmClient, int liveClassId, int userId) {
        this.cmsEngine = cmsEngine;
        this.rtmClient = rtmClient;
        this.liveClassId = liveClassId;
        this.userId = userId;
    }

    public CmsEngine getCmsEngine() {
        return cmsEngine;
    }

    public RtmClient getRtmClient() {
        return rtmClient;
    }

    public int getLiveClassId() {
        return liveClassId;
    }

    public int getUserId() {
        return userId;
    }
}
