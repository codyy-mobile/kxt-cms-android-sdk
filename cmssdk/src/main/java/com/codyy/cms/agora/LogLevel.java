package com.codyy.cms.agora;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Deprecated
@Retention(RetentionPolicy.SOURCE)
public @interface LogLevel{
    String DEBUG="DEBUG";
    String WARNING="WARNING";
    String INFO="INFO";
}