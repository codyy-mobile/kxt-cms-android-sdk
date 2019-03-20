package com.codyy.cms.core;

public class CmsEngineOpts {

    /**
     * 声网提供的app id
     */
    private String appId;
    /**
     * 声网提供的app certificate。
     */
    private String token;
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


    public CmsEngineOpts(String appId, String token) {
        this.appId = appId;
        this.token = token;
    }



    public CmsEngineOpts(String appId, String token, int reconnectCount) {
        this.appId = appId;
        this.token = token;
        this.reconnectCount = reconnectCount;
    }



    public CmsEngineOpts(String appId, String token, int reconnectCount, int reconnectTime) {
        this.appId = appId;
        this.token = token;
        this.reconnectCount = reconnectCount;
        this.reconnectTime = reconnectTime;
    }

    public CmsEngineOpts(String appId, String token, int reconnectCount, int reconnectTime, int tokenLifeTime) {
        this.appId = appId;
        this.token = token;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
