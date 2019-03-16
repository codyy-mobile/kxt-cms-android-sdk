package com.codyy.cms.events.cls;

public class ExitTestingEvent {

    /**
     *  试卷id
     */
    private int testId;
    /**
     * 课堂测验编号
     */
    private int classTestId;

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
}
