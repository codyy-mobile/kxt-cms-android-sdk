package com.codyy.cms.ext.user;

import com.codyy.cms.core.LoginOptions;

public class User {
    public UserAttributes attributes;
    public Environment environment;
    public UserStates states;

    public User(LoginOptions loginOpts) {
        this.attributes = new UserAttributes();
        this.attributes.loginTime=System.currentTimeMillis();
        this.environment = new Environment();
        this.states = new UserStates();
        this.states.isOnline=true;
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

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public UserStates getStates() {
        return states;
    }

    public void setStates(UserStates states) {
        this.states = states;
    }
}
