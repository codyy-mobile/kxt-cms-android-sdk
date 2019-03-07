package com.codyy.cms.core;

import com.codyy.cms.core.definition.Message;

/**
 * 消息回调接口定义
 */
public interface MessageHandler {
    /**
     * 处理消息
     * @param msgName {@link com.codyy.cms.core.definition.MessageName}
     * @param message {@link Message}
     */
    void handle(String msgName, Message message);
}
