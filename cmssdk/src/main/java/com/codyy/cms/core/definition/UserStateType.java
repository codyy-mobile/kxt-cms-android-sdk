package com.codyy.cms.core.definition;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface UserStateType {
    String USER = "user";
    String IS_ONLINE = "is_online";
    String IS_HANDING_UP = "is_handing_up";
    String IS_SIGNED_IN = "is_signed_in";
    String ALLOW_CHAT = "allow_chat";
    String SPEAKING_STATE = "speaking_state";
}
