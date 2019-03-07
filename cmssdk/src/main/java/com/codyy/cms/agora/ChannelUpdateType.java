package com.codyy.cms.agora;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface ChannelUpdateType {
    /**
     * 更新
     */
    String update="update";
    /**
     * 删除
     */
    String del="del";
    /**
     * 全部删除
     */
    String clear="clear";
    /**
     * 废弃字段
     */
    String set="set";
}
