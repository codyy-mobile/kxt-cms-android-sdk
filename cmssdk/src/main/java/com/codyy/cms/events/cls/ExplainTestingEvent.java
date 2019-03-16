package com.codyy.cms.events.cls;

import com.codyy.cms.core.definition.RenderType;
import com.codyy.cms.core.definition.TestType;

import java.util.List;

public class ExplainTestingEvent {

    /**
     * 试卷id
     */
    private int testId;
    /**
     * 课堂测验编号
     */
    private int classTestId;
    /**
     * "TEST" | "TEST_CARD", //测验或答题卡
     */
    private @TestType
    String testType;
    /**
     * 测验名称
     */
    private String testName;
    /**
     * isArray通过数组渲染 isAjax通过接口获取数据渲染
     */
    private @RenderType
    String renderType;
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

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getRenderType() {
        return renderType;
    }

    public void setRenderType(String renderType) {
        this.renderType = renderType;
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
