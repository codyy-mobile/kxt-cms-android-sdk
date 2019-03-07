package com.codyy.cms.core.definition;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 白板类型
 */
@Retention(RetentionPolicy.SOURCE)
public @interface WhiteboardType {
    String CANVAS = "canvas";
    String IMAGE = "image";
    String HTML = "html";
    String PDF = "pdf";
}
