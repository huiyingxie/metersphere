package io.metersphere.base.domain;

import java.io.Serializable;
import lombok.Data;

@Data
public class TestPlanExecutionQueue implements Serializable {
    private String id;

    private String reportId;

    private String runMode;

    private Long createTime;

    private String testPlanId;

    private static final long serialVersionUID = 1L;
}