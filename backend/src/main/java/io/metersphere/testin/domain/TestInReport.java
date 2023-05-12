package io.metersphere.testin.domain;

/**
 * Describe
 *
 * @author maguangming
 * @since 2023/5/11 17:56
 */
public class TestInReport extends BaseDomain{

    private String id;
    private String msTestPlanId;

    private String msCaseId;

    private Integer testInScriptNo;

    public String getMsTestPlanId() {
        return msTestPlanId;
    }

    public void setMsTestPlanId(String msTestPlanId) {
        this.msTestPlanId = msTestPlanId;
    }

    public String getMsCaseId() {
        return msCaseId;
    }

    public void setMsCaseId(String msCaseId) {
        this.msCaseId = msCaseId;
    }

    public Integer getTestInScriptNo() {
        return testInScriptNo;
    }

    public void setTestInScriptNo(Integer testInScriptNo) {
        this.testInScriptNo = testInScriptNo;
    }
}
