package com.codyy.cms.events.cls;

public class EndTestingEvent {

    /**
     * testId : testId
     * classTestId : classTestId
     */

    private String testId;
    private String classTestId;

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

}
