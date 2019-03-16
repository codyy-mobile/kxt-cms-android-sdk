package com.codyy.cms.core.definition;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 测验或答题卡类型
 */
@Retention(RetentionPolicy.SOURCE)
public @interface TestType {
    String TEST = "TEST";
    String TEST_CARD = "TEST_CARD";
}
