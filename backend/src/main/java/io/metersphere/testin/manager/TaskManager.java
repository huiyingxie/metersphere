package io.metersphere.testin.manager;

import com.fasterxml.jackson.annotation.JsonProperty;
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
import java.util.List;
import java.util.stream.Collectors;

/**
 * Describe
 *
 * @author maguangming
 * @since 2023/5/9 17:58
 */
@Component
public class TaskManager {
    public static final String REAL_TEST = "realtest";
    public static final String TASK_DESCR = "taskDescr";
    public static final String CALLBACK_URL = "callbackUrl";
    public static final String BIZ_CODE = "bizCode";
    public static final String SCRIPTS = "scripts";
    public static final String APP = "app";
    public static final String NO_APP = "noApp";
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private TestInConfig testInConfig;

    public String initData(String userEmail,
                           String taskDescr,
                           String callbackUrl,
                           int bizCode,
                           Integer noApp,
                           List<Long> scriptsNoList) {

        final List<ScriptsItem> scriptsItems = scriptsNoList.stream().map(no -> {
            final ScriptsItem item = new ScriptsItem();
            item.setScriptNo(no);
            item.setStandard(ScriptsItem.StandardDTO.buildDefault());
            return item;
        }).collect(Collectors.toList());
        final TestInBaseRequest<Object> request = BaseRequestBuilder.builder()
                .withApikey(testInConfig.getApiKey())
                .withMkey(REAL_TEST)
                .withOp(ApiOptions.Task.INIT_DATA)
                .withData(ReqMapDataBuilder.builder()
                        .withUser(userEmail)
                        .withParam(TASK_DESCR, taskDescr)
                        .withParam(CALLBACK_URL, callbackUrl)
                        .withParam(NO_APP, noApp)
                        .withParam(BIZ_CODE, bizCode)
                        .withParam(SCRIPTS, scriptsItems)
                        .build())
                .withAction(APP)
                .build();
        ParameterizedTypeReference<TestInBaseRespond<ResultDto>> reference =
                new ParameterizedTypeReference<TestInBaseRespond<ResultDto>>() {
                };

        final ResponseEntity<TestInBaseRespond<ResultDto>> responseEntity = restTemplate.exchange(testInConfig.getBaseApiUrl(), HttpMethod.POST, new HttpEntity<>(request), reference);
        LogUtil.info("云测任务初始化响应：{}", responseEntity);
        final TestInBaseRespond<ResultDto> respond = responseEntity.getBody();
        if (respond == null || !respond.isSuccess()) {
            String errMsg = respond != null ? respond.getMsg() : "";
            MSException.throwException("访问云测接口失败: " + errMsg);
        }
        return respond.getData().getResult();
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
