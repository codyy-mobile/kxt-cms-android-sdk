package com.codyy.cms.events.cls;

import java.util.List;

public class BeginTestCardEvent {

    /**
     * testCardId : 0
     * duration : 10
     * totalNumber : 10
     * items : ["SS","MS","T"]
     */
    /**
     *  答题卡id
     */
    private int testCardId;
    /**
     * 时长，单位分钟
     */
    private int duration;
    /**
     * 题目数
     */
    private int totalNumber;
    /**
     * 数组下标为题号，SS:单选， MS：多选， T：是非
     */
    private List<String> items;

    public int getTestCardId() {
        return testCardId;
    }

    public void setTestCardId(int testCardId) {
        this.testCardId = testCardId;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
}
