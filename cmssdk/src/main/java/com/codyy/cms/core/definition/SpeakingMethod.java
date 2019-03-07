package com.codyy.cms.core.definition;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 连麦方式
 */
@Retention(RetentionPolicy.SOURCE)
public @interface SpeakingMethod {
    String VIDEO = "video";
    String AUDIO = "audio";
}
