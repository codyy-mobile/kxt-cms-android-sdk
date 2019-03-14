package com.codyy.cms.events.sys;


public class Screenshot {

    /**
     * originalMsgId :
     * imageUrl :
     * classUserRole :
     * device :
     * os :
     */

    private String originalMsgId;
    private String imageUrl;
    /**
     * {@link com.codyy.cms.core.definition.ClassUserRole}
     */
    private String classUserRole;
    /**
     * {@link com.codyy.cms.core.definition.Device}
     */
    private String device;
    /**
     * {@link com.codyy.cms.core.definition.OS}
     */
    private String os;

    public String getOriginalMsgId() {
        return originalMsgId;
    }

    public void setOriginalMsgId(String originalMsgId) {
        this.originalMsgId = originalMsgId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getClassUserRole() {
        return classUserRole;
    }

    public void setClassUserRole(String classUserRole) {
        this.classUserRole = classUserRole;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public Screenshot(String originalMsgId, String imageUrl, String classUserRole, String device, String os) {
        this.originalMsgId = originalMsgId;
        this.imageUrl = imageUrl;
        this.classUserRole = classUserRole;
        this.device = device;
        this.os = os;
    }
}
