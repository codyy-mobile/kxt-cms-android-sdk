package com.codyy.cms.events.cls;

import java.util.List;

public class EndTestCardEvent {
    /**
     * 试卷id
     */
    private int testId;
    /**
     * 课堂测验编号
     */
    private int classTestId;
    /**
     * 测验名称
     */
    private String testName;
    /**
     * 是否测验讲解，为true时需要填写下面4个字段
     */
    private boolean explainingTest;
    /**
     * isArray通过数组渲染 isAjax通过接口获取数据渲染
     */
    private String type;
    /**
     * 试卷以图片的形式，数组内容为图片的url地址
     */
    private List<String> data;
    /**
     * 当前白板的id
     */
    private int wbNumber;
    /**
     * 扩展代码
     */
    private String extraHtmlFragment;

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

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public boolean isExplainingTest() {
        return explainingTest;
    }

    public void setExplainingTest(boolean explainingTest) {
        this.explainingTest = explainingTest;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public int getWbNumber() {
        return wbNumber;
    }

    public void setWbNumber(int wbNumber) {
        this.wbNumber = wbNumber;
    }

    public String getExtraHtmlFragment() {
        return extraHtmlFragment;
    }

    public void setExtraHtmlFragment(String extraHtmlFragment) {
        this.extraHtmlFragment = extraHtmlFragment;
    }
}
