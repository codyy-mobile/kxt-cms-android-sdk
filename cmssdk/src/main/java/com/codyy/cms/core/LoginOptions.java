package com.codyy.cms.core;

public class LoginOptions {
    private int userId;
    private String userName;
    /**
     * {@link com.codyy.cms.core.definition.UserRole}
     */
    private String userRole;
    /**
     * {@link com.codyy.cms.core.definition.ClassUserRole}
     */
    private String classUserRole;

    public LoginOptions(int userId, String userName, String userRole, String classUserRole) {
        this.userId = userId;
        this.userName = userName;
        this.userRole = userRole;
        this.classUserRole = classUserRole;
    }

    public LoginOptions(int userId) {
        this.userId = userId;
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
}
