package com.codyy.cms.core.definition;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 说话状态
 */
@Retention(RetentionPolicy.SOURCE)
public @interface SpeakingState {
    String NO = "no";
    String VIDEO = "video";
    String AUDIO = "audio";
}
