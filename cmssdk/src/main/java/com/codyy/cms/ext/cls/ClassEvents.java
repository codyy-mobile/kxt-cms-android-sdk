package com.codyy.cms.ext.cls;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface ClassEvents {
    String ON_TESTCARD_RESULT_RECEIVED = "on_testcard_result_received";
}
