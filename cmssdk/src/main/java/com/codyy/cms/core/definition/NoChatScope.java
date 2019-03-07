package com.codyy.cms.core.definition;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 禁言范围
 */
@Retention(RetentionPolicy.SOURCE)
public @interface NoChatScope {
    String ALL = "all";
    String SINGLE = "single";
}
