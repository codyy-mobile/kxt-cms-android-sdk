package com.codyy.cms.core;

import com.codyy.cms.core.definition.MessageType;

import java.util.ArrayList;

public interface MessageModule extends MessageHandler {
    /**
     * Return message module type.
     *
     * @returns {@link MessageType}
     * @memberof MessageModule
     */
    String getType();

    /**
     * Return names of messages which are subscribed by this module from message dispatcher.
     *
     * @returns {string}
     * @memberof MessageModule
     */
    ArrayList<String> getWatchMsgNames();

    /**
     * 加载数据
     *
     * @memberof MessageModule
     */
    void load();

    /**
     * 保持数据
     *
     * @memberof MessageModule
     */
    void save();
}
