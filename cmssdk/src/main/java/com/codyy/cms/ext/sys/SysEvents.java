package com.codyy.cms.ext.sys;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface SysEvents {
    String ON_CAPTURE_SCREEN_RECEIVED = "on_capture_screen_received";
    String ON_CAPTURE_SCREEN_URL_RECEIVED = "on_caputre_screen_url_received";
    String ON_SWITCH_APP_RECEIVED = "on_switch_app_received";
}
