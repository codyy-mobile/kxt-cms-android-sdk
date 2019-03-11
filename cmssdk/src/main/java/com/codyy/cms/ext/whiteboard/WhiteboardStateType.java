package com.codyy.cms.ext.whiteboard;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface WhiteboardStateType {
    String IS_FREE_OPERATION = "is_free_operation";
}
