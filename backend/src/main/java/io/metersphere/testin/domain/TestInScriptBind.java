package io.metersphere.testin.domain;

import lombok.Data;

/**
 * Describe
 *
 * @author maguangming
 * @since 2023/5/11 17:42
 */
public class TestInScriptBind extends BaseDomain {

    private String id;

    private String msCaseId;

    private Long testInScriptNo;

    private String testInScriptName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
