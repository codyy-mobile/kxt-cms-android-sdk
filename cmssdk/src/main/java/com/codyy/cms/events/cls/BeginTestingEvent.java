package com.codyy.cms.events.cls;

public class BeginTestingEvent {

    /**
     * testId : testId
     * classTestId : classTestId
     * duration : 10
     * totalNumber : 5
     */

    private int testId;
    private int classTestId;
    private int duration;
    private int totalNumber;
    /**
     *"TEST" | "TEST_CARD", //测验或答题卡
     */
    private String testType;

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getClassTestId() {
        return classTestId;
    }

    public void setClassTestId(int classTestId) {
        this.classTestId = classTestId;
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
}
