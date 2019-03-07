package com.codyy.cms.core.definition;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 播放类型
 */
@Retention(RetentionPolicy.SOURCE)
public @interface PlayType {
    String IMAGE = "image";
    String VIDEO = "video";
    String AUDIO = "audio";
}
