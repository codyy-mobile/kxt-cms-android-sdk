package com.codyy.cms.core.definition;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Used for Message class_adjust_video(教师端画面缩放或全屏)
 */
@Retention(RetentionPolicy.SOURCE)
public @interface VideoZoomState {
    String DEFAULT = "default";
    String FULL = "full";
    String ZOOM_IN = "zoom_in";
}
