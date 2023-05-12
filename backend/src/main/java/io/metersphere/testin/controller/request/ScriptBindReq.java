package io.metersphere.testin.controller.request;

/**
 * Describe
 *
 * @author maguangming
 * @since 2023/5/11 17:22
 */
public class ScriptBindReq {

    private String msCaseId;

    private Long testInScriptNo;

    private String testInScriptName;

    public String getMsCaseId() {
        return msCaseId;
    }

    public void setMsCaseId(String msCaseId) {
        this.msCaseId = msCaseId;
    }

    public Long getTestInScriptNo() {
        return testInScriptNo;
    }

    public void setTestInScriptNo(Long testInScriptNo) {
        this.testInScriptNo = testInScriptNo;
    }

    public String getTestInScriptName() {
        return testInScriptName;
    }

    public void setTestInScriptName(String testInScriptName) {
        this.testInScriptName = testInScriptName;
    }
}
