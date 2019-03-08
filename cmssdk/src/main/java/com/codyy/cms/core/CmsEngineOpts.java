package com.codyy.cms.core;

public class CmsEngineOpts {

    /**
     * 声网提供的app id
     */
    private String appId;
    /**
     * 声网提供的app certificate。
     */
    private String appCertificate;
    /**
     * 登录重试次数
     */
    private int reconnectCount;
    /**
     * 登录超时时间
     */
    private int reconnectTime;
    /**
     * 用户在信令系统中的有效时间
     */
    private int tokenLifeTime;

    public CmsEngineOpts() {
    }

    public CmsEngineOpts(String appId) {
        this.appId = appId;
    }

    public CmsEngineOpts(String appId, String appCertificate) {
        this.appId = appId;
        this.appCertificate = appCertificate;
    }

    public CmsEngineOpts(String appId, String appCertificate, int reconnectCount) {
        this.appId = appId;
        this.appCertificate = appCertificate;
        this.reconnectCount = reconnectCount;
    }

    public CmsEngineOpts(String appId, String appCertificate, int reconnectCount, int reconnectTime) {
        this.appId = appId;
        this.appCertificate = appCertificate;
        this.reconnectCount = reconnectCount;
        this.reconnectTime = reconnectTime;
    }

    public CmsEngineOpts(String appId, String appCertificate, int reconnectCount, int reconnectTime, int tokenLifeTime) {
        this.appId = appId;
        this.appCertificate = appCertificate;
        this.reconnectCount = reconnectCount;
        this.reconnectTime = reconnectTime;
        this.tokenLifeTime = tokenLifeTime;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppCertificate() {
        return appCertificate;
    }

    public void setAppCertificate(String appCertificate) {
        this.appCertificate = appCertificate;
    }

    public int getReconnectCount() {
        return reconnectCount;
    }

    public void setReconnectCount(int reconnectCount) {
        this.reconnectCount = reconnectCount;
    }

    public int getReconnectTime() {
        return reconnectTime;
    }

    public void setReconnectTime(int reconnectTime) {
        this.reconnectTime = reconnectTime;
    }

    public int getTokenLifeTime() {
        return tokenLifeTime;
    }

    public void setTokenLifeTime(int tokenLifeTime) {
        this.tokenLifeTime = tokenLifeTime;
    }
}
