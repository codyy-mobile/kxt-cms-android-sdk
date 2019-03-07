package com.codyy.cms.core.definition;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 消息的发送类型。
 */
@Retention(RetentionPolicy.SOURCE)
public @interface MsgSendType {
    /**
     * Global Peer to Peer.
     * 全局点对点消息
     * 声网是否支持：是
     * 实现方案：默认方案
     */
    String GP2P = "GP2P";

    /**
     * Global Peer to Multiple (Not support)
     * 全局点对多消息
     * 声网是否支持：否
     * 实现方案：无此需求，可暂不支持
     */
    String GP2M = "GP2M";

    /**
     * Channel Peer to Peer
     * 组内点对点消息
     * 声网是否支持：否
     * 实现方案：由CMS SDK使用全局点对点{@link MsgSendType#GP2P}代替
     */
    String CP2P = "CP2P";

    /**
     * Channel Peer to Multiple
     * 组内点对多消息
     * 声网是否支持：否
     * 实现方案：使用全局点对点{@link MsgSendType#GP2P},由CMS SDK实现发送多次
     */
    String CP2M = "CP2M";

    /**
     * Channel Peer to All
     * 组内广播
     * 声网是否支持：是
     * 实现方案：默认方案
     */
    String CP2A = "CP2A";
}
