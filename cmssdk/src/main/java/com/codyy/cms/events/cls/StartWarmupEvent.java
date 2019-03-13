package com.codyy.cms.events.cls;

import java.util.List;

public class StartWarmupEvent {

    /**
     * playType : image
     * sources : []
     */

    private String playType;
    private List<String> sources;

    public String getPlayType() {
        return playType;
    }

    public void setPlayType(String playType) {
        this.playType = playType;
    }

    public List<String> getSources() {
        return sources;
    }

    public void setSources(List<String> sources) {
        this.sources = sources;
    }
}
