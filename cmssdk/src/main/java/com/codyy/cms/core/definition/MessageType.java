package com.codyy.cms.core.definition;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 消息类型
 */
@Retention(RetentionPolicy.SOURCE)
public @interface MessageType {
    String CLASS = "class"; // 课堂类消息
    String USER = "user"; // 用户类消息
    String TEXTCHAT = "textchat"; // 文字交流类消息
    String WHITEBOARD = "whiteboard"; // 白板类消息
    /**
     * use {@link MessageType#SYS} instead of this type
     */
    @Deprecated
    String MONITOR = "monitor"; // 监控类消息
    String SYS = "sys"; // 系统类消息
}
