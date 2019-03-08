package com.codyy.cms.core.user;

import android.text.TextUtils;

public class User {
    private UserAttributes attributes;
    private Environment env;
    private UserStates states;

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
