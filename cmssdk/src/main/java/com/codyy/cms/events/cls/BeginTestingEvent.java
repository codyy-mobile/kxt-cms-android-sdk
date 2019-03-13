package com.codyy.cms.events.cls;

public class BeginTestingEvent {

    /**
     * testId : testId
     * classTestId : classTestId
     * duration : 10
     * totalNumber : 5
     */

    private String testId;
    private String classTestId;
    private int duration;
    private int totalNumber;

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getClassTestId() {
        return classTestId;
    }

    public void setClassTestId(String classTestId) {
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
