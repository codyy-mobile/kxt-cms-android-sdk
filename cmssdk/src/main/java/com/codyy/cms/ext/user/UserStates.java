package com.codyy.cms.ext.user;

import com.codyy.cms.core.definition.SpeakingState;

public class UserStates {
    /**
     * 是否在线
     */
    public boolean isOnline;
    /**
     * 禁言状态
     */
    public boolean allowChat;
    /**
     * 是否在举手
     */
    public boolean isHandingUp;
    public String speakingState = SpeakingState.NO;
    /**
     * 是否签过到
     */
    public boolean isSignedIn;

    public UserStates() {
    }

    public UserStates(boolean isOnline, boolean allowChat, boolean isHandingUp, String speakingState, boolean isSignedIn) {
        this.isOnline = isOnline;
        this.allowChat = allowChat;
        this.isHandingUp = isHandingUp;
        this.speakingState = speakingState;
        this.isSignedIn = isSignedIn;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public boolean isAllowChat() {
        return allowChat;
    }

    public void setAllowChat(boolean allowChat) {
        this.allowChat = allowChat;
    }

    public boolean isHandingUp() {
        return isHandingUp;
    }

    public void setHandingUp(boolean handingUp) {
        isHandingUp = handingUp;
    }

    public String getSpeakingState() {
        return speakingState;
    }

    public void setSpeakingState(String speakingState) {
        this.speakingState = speakingState;
    }

    public boolean isSignedIn() {
        return isSignedIn;
    }

    public void setSignedIn(boolean signedIn) {
        isSignedIn = signedIn;
    }
}
