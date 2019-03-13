package com.codyy.cms.events.cls;

public class AdjustVideoEvent {

    /**
     * videoUserId : 123
     * action : default
     */
    /**
     * 缩放哪个用户的视频画面，视频对应的用户ID
     */
    private int videoUserId;
    /**
     * default：默认，full：全屏，zoomin：放大
     */
    private String action;

    public int getVideoUserId() {
        return videoUserId;
    }

    public void setVideoUserId(int videoUserId) {
        this.videoUserId = videoUserId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
