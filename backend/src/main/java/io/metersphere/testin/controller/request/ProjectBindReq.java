package io.metersphere.testin.controller.request;

/**
 * Describe
 *
 * @author maguangming
 * @since 2023/5/11 17:04
 */
public class ProjectBindReq {

    private String msProjectId;

    private Integer testInProjectId;

    private String testInProjectName;

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
