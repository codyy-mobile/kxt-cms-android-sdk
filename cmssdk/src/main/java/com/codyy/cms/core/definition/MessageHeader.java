package com.codyy.cms.core.definition;

import java.util.ArrayList;

public class MessageHeader {
    /**
     * 消息唯一编号. Not null
     * 消息ID（id）
     * 由三部份组成，每部分用“-”做连接符，第一部分为live class id，第二部分为user id，第三部分为从0开始的自增自然整数，消息id为变长，最小长度为5字节。
     */
    private String id;
    /**
     * 消息全局名称，英文，128字节限制. Not null
     * {@link MessageName}
     */
    private String name;
    /**
     * 消息内部版本号，默认为‘1.0.0’.
     */
    private String version = "1.0.0";
    /**
     * 消息类型，枚举类型. Not null
     */
    private String type;
    /**
     * 消息发送类型，枚举类型，只发送时有意义，消息接收时此字段无意义。Not null
     */
    private String sendType;
    /**
     * 消息发送者阔地用户id
     */
    private int userId;
    /**
     * 消息接受者阔地用户账号列表. 由于性能问题，接收人数小于等于30人时使用CP2M，超过30人使用CP2A方式。
     */
    private ArrayList<Integer> targetUserIds;
    /**
     * 消息时间戳， long型. Not null
     */
    private long timestamp;
    /**
     * 消息发送者所在的通道Id.
     */
    private String channelId;
    /**
     * 消息是否有回复，如有回复发送者需要创建回调等待回复到达，回复超时为10秒钟。true/false。只支持点对点消息
     */
    private boolean hasResponse;
    /**
     * 是否为应答消息。
     */
    private boolean isResponse;
    /**
     * 消息应答时，填入响应消息的id
     */
    private String originalId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public ArrayList<Integer> getTargetUserIds() {
        return targetUserIds;
    }

    public void setTargetUserIds(ArrayList<Integer> targetUserIds) {
        this.targetUserIds = targetUserIds;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public boolean isHasResponse() {
        return hasResponse;
    }

    public void setHasResponse(boolean hasResponse) {
        this.hasResponse = hasResponse;
    }

    public boolean isResponse() {
        return isResponse;
    }

    public void setResponse(boolean response) {
        isResponse = response;
    }

    public String getOriginalId() {
        return originalId;
    }

    public void setOriginalId(String originalId) {
        this.originalId = originalId;
    }
}
