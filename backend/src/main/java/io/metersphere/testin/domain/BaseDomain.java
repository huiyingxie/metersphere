package io.metersphere.testin.domain;

/**
 * Describe
 *
 * @author maguangming
 * @since 2023/5/11 17:49
 */
public class BaseDomain {

    private Long createTime;

    private String creator;

    private Long updateTime;

    private String updateUser;

    private Integer delFlag = 0;

    private Long delTime;

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Long getDelTime() {
        return delTime;
    }

    public void setDelTime(Long delTime) {
        this.delTime = delTime;
    }
}
