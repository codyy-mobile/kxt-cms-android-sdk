package com.codyy.cms.core.definition;

/**
 * The interface defines fields to show result of sending message. It is used as Promise parameter of MessageEngine.sendMessage function.
 */
public class MessageResult {
    /**
     * Message id.
     */
    private String msgId;
    /**
     * Indicate if message is sent.
     */
    private boolean hasSent;
    /**
     * Indicate if message is recieved by peer.
     */
    private boolean hasPeerReceived;
    /**
     * Error code.
     */
    private String ecode;
    /**
     * Error message.
     */
    private String error;

    public MessageResult(String msgId, boolean hasSent, boolean hasPeerReceived, String ecode, String error) {
        this.msgId = msgId;
        this.hasSent = hasSent;
        this.hasPeerReceived = hasPeerReceived;
        this.ecode = ecode;
        this.error = error;
    }

    public MessageResult() {
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public boolean isHasSent() {
        return hasSent;
    }

    public void setHasSent(boolean hasSent) {
        this.hasSent = hasSent;
    }

    public boolean isHasPeerReceived() {
        return hasPeerReceived;
    }

    public void setHasPeerReceived(boolean hasPeerReceived) {
        this.hasPeerReceived = hasPeerReceived;
    }

    public String getEcode() {
        return ecode;
    }

    public void setEcode(String ecode) {
        this.ecode = ecode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
