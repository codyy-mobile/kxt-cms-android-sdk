package com.codyy.cms.ext.user;

import android.text.TextUtils;

import com.codyy.cms.core.LoginOptions;

public class User {
    public UserAttributes attributes;
    public Environment env;
    public UserStates states;

    public User(int userId, String userName, String userNumber) {
        this.attributes = new UserAttributes();
        this.env = new Environment();
        this.states = new UserStates();

        this.attributes.setUserId(userId);
        this.attributes.setUserName(userName);
        if (!TextUtils.isEmpty(userNumber)) {
            this.attributes.setUserNumber(userNumber);
        }
    }

    public User(LoginOptions loginOpts) {
        this.attributes = new UserAttributes();
        this.env = new Environment();
        this.states = new UserStates();

        this.attributes.setUserId(loginOpts.getUserId());
        this.attributes.setUserName(loginOpts.getUserName());
        this.attributes.setUserRole(loginOpts.getUserRole());
        this.attributes.setClassUserRole(loginOpts.getClassUserRole());
    }

    public UserAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(UserAttributes attributes) {
        this.attributes = attributes;
    }

    public Environment getEnv() {
        return env;
    }

    public void setEnv(Environment env) {
        this.env = env;
    }

    public UserStates getStates() {
        return states;
    }

    public void setStates(UserStates states) {
        this.states = states;
    }
}