package com.codyy.cms.ext.user;

public class Environment {
    /**
     * {@link com.codyy.cms.core.definition.Device}
     */
    private String device;
    /**
     * {@link com.codyy.cms.core.definition.OS}
     */
    private String os;
    private String osVersion="1.0.0";
    /**
     * 浏览器类型和版本
     */
    private String browser;
    /**
     * 小阔应用版本
     */
    private String appVersion;
    /**
     * true:有摄像头， false：没摄像头
     */
    private boolean video;
    /**
     *  true:有麦克风， false：没麦克风
     */
    private boolean audio;

    public Environment() {
    }

    public Environment(String device, String os, String osVersion, String browser, String appVersion, boolean video, boolean audio) {
        this.device = device;
        this.os = os;
        this.osVersion = osVersion;
        this.browser = browser;
        this.appVersion = appVersion;
        this.video = video;
        this.audio = audio;
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

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public boolean isAudio() {
        return audio;
    }

    public void setAudio(boolean audio) {
        this.audio = audio;
    }
}
