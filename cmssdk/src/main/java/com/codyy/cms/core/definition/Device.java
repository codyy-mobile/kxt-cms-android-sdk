package com.codyy.cms.core.definition;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 设备
 */
@Retention(RetentionPolicy.SOURCE)
public @interface Device {
    String PC = "pc";
    String PHONE = "phone";
    String PAD = "pad";
}
