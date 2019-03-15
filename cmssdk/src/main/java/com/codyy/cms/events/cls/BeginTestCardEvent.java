package com.codyy.cms.events.cls;

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
    private int testId;
    /**
     * 时长，单位分钟
     */
    private int duration;
    /**
     * 题目数
     */
    private int totalNumber;

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

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }
}
