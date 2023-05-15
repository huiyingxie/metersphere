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

    /**
     * 脚本执行策略-覆盖安装
     */
    private Integer coverInstall;

    /**
     * 脚本执行策略-清理数据
     */
    private Integer cleanData;

    /**
     * 脚本执行策略-保持应用
     */
    private Integer keepApp;

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

    public Integer getCoverInstall() {
        return coverInstall;
    }

    public void setCoverInstall(Integer coverInstall) {
        this.coverInstall = coverInstall;
    }

    public Integer getCleanData() {
        return cleanData;
    }

    public void setCleanData(Integer cleanData) {
        this.cleanData = cleanData;
    }

    public Integer getKeepApp() {
        return keepApp;
    }

    public void setKeepApp(Integer keepApp) {
        this.keepApp = keepApp;
    }
}
