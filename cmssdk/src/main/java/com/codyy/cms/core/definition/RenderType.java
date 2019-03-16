package com.codyy.cms.core.definition;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * isArray通过数组渲染 isAjax通过接口获取数据渲染
 */
@Retention(RetentionPolicy.SOURCE)
public @interface RenderType {
    String IS_ARRAY = "isArray";
    String IS_AJAX = "isAjax";
}
