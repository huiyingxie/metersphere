package io.metersphere.testin.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * TestIn 云测 项目列表
 *
 * @author maguangming
 * @since 2023/5/10 10:55
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TiProjectItem {

    @JsonProperty("eid")
    private Integer eid;
    @JsonProperty("createTime")
    private Long createTime;
    @JsonProperty("name")
    private String name;
    @JsonProperty("projectid")
    private Integer projectid;
    @JsonProperty("status")
    private Integer status;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TiProjectItem{" +
                "eid=" + eid +
                ", createTime=" + createTime +
                ", name='" + name + '\'' +
                ", projectid=" + projectid +
                ", status=" + status +
                '}';
    }
}
