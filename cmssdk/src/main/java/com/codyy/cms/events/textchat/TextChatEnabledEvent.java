package com.codyy.cms.events.textchat;

public class TextChatEnabledEvent {
    private boolean isEnabled;
    /**
     * 默认值为all。当为all是表示解除禁言所有人，但是单独禁言的人不能被同时解除；单独解除禁言scope值必须为single
     */
    private String scope;
    private int userId;

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
