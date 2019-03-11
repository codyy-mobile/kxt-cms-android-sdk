package com.codyy.cms.ext.textchat;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface TextchatStateType {
    String ALLOW_ALL_CHATING = "allow_all_chating";
    String QUESTION_VISIBLE = "question_visible";
}
