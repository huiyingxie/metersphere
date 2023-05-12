package io.metersphere.testin.controller.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

/**
 * 启动TestIn任务初始化
 *
 * @author maguangming
 * @since 2023/5/12 11:00
 */
@ApiModel
public class StartTaskInitReq {

    @ApiModelProperty("测试计划ID")
    @NotEmpty
    private String msTestPlanId;

    @ApiModelProperty(value = "无应用测试（默认0)")
    private Integer noApp;

    public String getMsTestPlanId() {
        return msTestPlanId;
    }

    public void setMsTestPlanId(String msTestPlanId) {
        this.msTestPlanId = msTestPlanId;
    }

    public Integer getNoApp() {
        return noApp;
    }

    public void setNoApp(Integer noApp) {
        this.noApp = noApp;
    }
}
