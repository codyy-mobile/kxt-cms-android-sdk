package com.codyy.cms.ext.user;

import com.codyy.cms.core.definition.ClassUserRole;
import com.codyy.cms.core.definition.UserRole;

public class UserAttributes {
    /**
     * 用户ID
     */
    public int userId;
    /**
     * 用户姓名
     */
    public String userName;
    /**
     * 用户角色
     * {@link com.codyy.cms.core.definition.UserRole}
     */
    public @UserRole
    String userRole;
    /**
     * 用户课堂内角色
     * {@link com.codyy.cms.core.definition.ClassUserRole}
     */
    public @ClassUserRole
    String classUserRole;
    /**
     * 用户登录时间
     */
    public long loginTime;
    /**
     * 用户举手次数
     */
    public int handupTimes;
    /**
     * 用户签到次数
     */
    public int signinTimes = 0;

    public UserAttributes() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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


    public int getHandupTimes() {
        return handupTimes;
    }

    public void setHandupTimes(int handupTimes) {
        this.handupTimes = handupTimes;
    }


    public int getSigninTimes() {
        return signinTimes;
    }

    public void setSigninTimes(int signinTimes) {
        this.signinTimes = signinTimes;
    }
}
