package io.metersphere.testin.manager;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.metersphere.commons.exception.MSException;
import io.metersphere.commons.utils.LogUtil;
import io.metersphere.config.TestInConfig;
import io.metersphere.testin.common.ApiOptions;
import io.metersphere.testin.dto.*;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.LinkedHashMap;

/**
 * Describe
 *
 * @author maguangming
 * @since 2023/5/9 17:58
 */
@Component
public class ReportManager {
    public static final String PROJECT_ID = "projectid";
    public static final String REAL_TEST = "realtest";
    public static final String ANALYSIS = "analysis";
    public static final String TASK_ID = "taskid";
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private TestInConfig testInConfig;

    public TaskReportData list(String userEmail,
                                              int projectId,
                                              String taskId,
                                              int page,
                                              int pageSize) {

        final TestInBaseRequest<Object> request = BaseRequestBuilder.builder()
                .withApikey(testInConfig.getApiKey())
                .withMkey(REAL_TEST)
                .withAction(ANALYSIS)
                .withOp(ApiOptions.Report.LIST)
                .withData(ReqMapDataBuilder.builder()
                        .withUser(userEmail)
                        .withParam(PROJECT_ID, projectId)
                        .withParam(TASK_ID, taskId)
                        .withPage(page)
                        .withPageSize(pageSize)
                        .build())
                .build();
        ParameterizedTypeReference<TestInBaseRespond<TaskReportData>> reference =
                new ParameterizedTypeReference<TestInBaseRespond<TaskReportData>>() {
                };

        try {
            System.out.println(new ObjectMapper().writeValueAsString(request));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        final ResponseEntity<TestInBaseRespond<TaskReportData>> responseEntity = restTemplate.exchange(testInConfig.getBaseApiUrl(), HttpMethod.POST, new HttpEntity<>(request), reference);
        LogUtil.info("获取云测任务报告列表响应：{}", responseEntity);
        final TestInBaseRespond<TaskReportData> respond = responseEntity.getBody();
        if (respond == null || !respond.isSuccess()) {
            String errMsg = respond != null ? respond.getMsg() : "";
            MSException.throwException("访问云测接口失败: " + errMsg);
        }
        return respond.getData();
    }

    public static class ScriptsItem {
        @JsonProperty("scriptNo")
        private Long scriptNo;
        @JsonProperty("standard")
        private StandardDTO standard;

        public Long getScriptNo() {
            return scriptNo;
        }

        public void setScriptNo(Long scriptNo) {
            this.scriptNo = scriptNo;
        }

        public StandardDTO getStandard() {
            return standard;
        }

        public void setStandard(StandardDTO standard) {
            this.standard = standard;
        }

        public static class StandardDTO {
            @JsonProperty("coverInstall")
            private Integer coverInstall;
            @JsonProperty("cleanData")
            private Integer cleanData;
            @JsonProperty("keepApp")
            private Integer keepApp;

            public static StandardDTO buildDefault() {
                final StandardDTO standardDTO = new StandardDTO();
                standardDTO.setCleanData(1);
                standardDTO.setCoverInstall(1);
                standardDTO.setKeepApp(1);
                return standardDTO;
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
    }
}
