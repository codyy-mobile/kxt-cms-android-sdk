package com.codyy.cms.core.definition;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 用户角色
 */
@Retention(RetentionPolicy.SOURCE)
public @interface UserRole {
    /**
     * 游客
     */
    String VISITOR="VISITOR";
    /**
     * 学生
     */
    String STUDENT="STUDENT";
    /**
     * 机构管理员
     */
    String ORG_TEACHER="ORG_TEACHER";
    /**
     * 教师
     */
    String TEACHER="TEACHER";
    /**
     * 管理员
     */
    String ADMIN="ADMIN";
}
