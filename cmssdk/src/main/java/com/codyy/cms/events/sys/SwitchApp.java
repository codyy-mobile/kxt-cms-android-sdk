package com.codyy.cms.events.sys;


public class SwitchApp {

    /**
     * originalMsgId :
     * imageUrl :
     * classUserRole :
     * device :
     * os :
     */

    private String action;
    /**
     * 分钟
     */
    private int activeDuration;
    private int inactiveDuration;
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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getActiveDuration() {
        return activeDuration;
    }

    public void setActiveDuration(int activeDuration) {
        this.activeDuration = activeDuration;
    }

    public int getInactiveDuration() {
        return inactiveDuration;
    }

    public void setInactiveDuration(int inactiveDuration) {
        this.inactiveDuration = inactiveDuration;
    }

    public SwitchApp(String action, int activeDuration, int inactiveDuration, String classUserRole, String device, String os) {
        this.action = action;
        this.activeDuration = activeDuration;
        this.inactiveDuration = inactiveDuration;
        this.classUserRole = classUserRole;
        this.device = device;
        this.os = os;
    }
}
