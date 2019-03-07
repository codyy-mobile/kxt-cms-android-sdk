package com.codyy.cms.core.definition;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 锁键盘类型
 */
@Retention(RetentionPolicy.SOURCE)
public @interface LockAction {
    String LOCK = "lock";
    String UNLOCK = "unlock";
}
