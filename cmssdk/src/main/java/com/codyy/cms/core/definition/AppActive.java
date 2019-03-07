package com.codyy.cms.core.definition;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 应用程序是在前台还是后台。
 */
@Retention(RetentionPolicy.SOURCE)
public @interface AppActive {
    String ACTIVE = "active";
    String INACTIVE = "inactive";
}
