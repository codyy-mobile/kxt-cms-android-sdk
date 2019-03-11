package com.codyy.cms.ext.sys;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface SysStateType {
    String IS_KEYBOARD_LOCKED = "is_keyboard_locked";
}
