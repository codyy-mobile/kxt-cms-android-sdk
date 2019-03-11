package com.codyy.cms.ext.user;

public class UserAttributes {
    public int userId;
    public String userNumber;
    public String userName;
    /**
     * 用户角色
     * {@link com.codyy.cms.core.definition.UserRole}
     */
    public String userRole;
    /**
     * 用户课堂内角色
     * {@link com.codyy.cms.core.definition.ClassUserRole}
     */
    public String classUserRole;
    /**
     * 用户登录时间
     */
    public long loginTime;
    /**
     * 用户后台运行时长
     */
    public int inactiveTime;
    /**
     * 用户举手次数
     */
    public int handupTimes;
    /**
     * 用户在线时长
     */
    public int onlineTime;
    /**
     * 用户签到次数
     */
    public int signinTimes = 0;

    public UserAttributes() {
    }

    public UserAttributes(int userId, String userNumber, String userName, String userRole, String classUserRole, long loginTime, int inactiveTime, int handupTimes, int onlineTime, int signinTimes) {
        this.userId = userId;
        this.userNumber = userNumber;
        this.userName = userName;
        this.userRole = userRole;
        this.classUserRole = classUserRole;
        this.loginTime = loginTime;
        this.inactiveTime = inactiveTime;
        this.handupTimes = handupTimes;
        this.onlineTime = onlineTime;
        this.signinTimes = signinTimes;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getClassUserRole() {
        return classUserRole;
    }

    public void setClassUserRole(String classUserRole) {
        this.classUserRole = classUserRole;
    }

    public long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(long loginTime) {
        this.loginTime = loginTime;
    }

    public int getInactiveTime() {
        return inactiveTime;
    }

    public void setInactiveTime(int inactiveTime) {
        this.inactiveTime = inactiveTime;
    }

    public int getHandupTimes() {
        return handupTimes;
    }

    public void setHandupTimes(int handupTimes) {
        this.handupTimes = handupTimes;
    }

    public int getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(int onlineTime) {
        this.onlineTime = onlineTime;
    }

    public int getSigninTimes() {
        return signinTimes;
    }

    public void setSigninTimes(int signinTimes) {
        this.signinTimes = signinTimes;
    }
}
