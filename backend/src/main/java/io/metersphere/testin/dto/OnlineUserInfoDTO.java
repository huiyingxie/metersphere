package io.metersphere.testin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describe
 *
 * @author maguangming
 * @since 2023/5/9 17:43
 */
public class OnlineUserInfoDTO {
    @JsonProperty("email")
    private String email;

    @JsonProperty("projectId")
    private Integer projectId;

    public OnlineUserInfoDTO(String email) {
        this.email = email;
    }

    public OnlineUserInfoDTO(String email, Integer projectId) {
        this.email = email;
        this.projectId = projectId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "OnlineUserInfoDTO{" +
                "email='" + email + '\'' +
                ", projectId='" + projectId + '\'' +
                '}';
    }
}
