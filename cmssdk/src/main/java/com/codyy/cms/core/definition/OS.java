package com.codyy.cms.core.definition;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 操作系统
 */
@Retention(RetentionPolicy.SOURCE)
public @interface OS {
    String ANDROID = "Android";
    String IOS = "iOS";
    String WINDOWS = "Windows";
    String MACOS = "MacOS";
    String LINUX = "Linux";
}
