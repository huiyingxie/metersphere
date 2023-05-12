package io.metersphere.testin.domain;

import lombok.Data;

/**
 * Describe
 *
 * @author maguangming
 * @since 2023/5/11 17:42
 */
public class TestInProjectBind extends BaseDomain {

    private String id;

    private String msProjectId;

    private Integer testInProjectId;

    private String testInProjectName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMsProjectId() {
        return msProjectId;
    }

    public void setMsProjectId(String msProjectId) {
        this.msProjectId = msProjectId;
    }

    public Integer getTestInProjectId() {
        return testInProjectId;
    }

    public void setTestInProjectId(Integer testInProjectId) {
        this.testInProjectId = testInProjectId;
    }

    public String getTestInProjectName() {
        return testInProjectName;
    }

    public void setTestInProjectName(String testInProjectName) {
        this.testInProjectName = testInProjectName;
    }
}
