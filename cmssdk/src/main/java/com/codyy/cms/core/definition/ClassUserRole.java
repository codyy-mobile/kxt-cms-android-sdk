package com.codyy.cms.core.definition;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 课堂用户角色
 */
@Retention(RetentionPolicy.SOURCE)
public @interface ClassUserRole {
    /**
     * 游客
     */
    String VISITOR = "VISITOR";
    /**
     * 学生
     */
    String STUDENT = "STUDENT";
    /**
     * 主讲教师
     */
    String TEACHER = "TEACHER";
    /**
     * 助教
     */
    String ASSISTANT = "ASSISTANT";
    /**
     * 课堂管理员
     */
    String CLASS_ADMIN = "CLASS_ADMIN";
    /**
     * 后台匿名管理员（记录课堂状态信息并提供服务）
     */
    String ANONYMOUSE_ADMIN = "ANONYMOUSE_ADMIN";
}
