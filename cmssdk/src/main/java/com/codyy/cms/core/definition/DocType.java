package com.codyy.cms.core.definition;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 文档类型
 */
@Retention(RetentionPolicy.SOURCE)
public @interface DocType {
    String IMAGE = "image";
    String VIDEO = "video";
    String PDF = "pdf";
    String WORD = "word";
    String PPT = "ppt";
    String EXCEL = "excel";
    String HTML = "html";
}
