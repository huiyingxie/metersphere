package io.metersphere.testin.manager;

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

/**
 * Describe
 *
 * @author maguangming
 * @since 2023/5/9 17:58
 */
@Component
public class ScriptManager {
    //    public static final String URL = "";
    public static final int STATUS_DEFAULT = 1;
    public static final String SCRIPT = "script";
    public static final String PROJECT_ID = "projectId";
    public static final String SCRIPT_DESC = "scriptDesc";
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private TestInConfig testInConfig;

    public PageData<List<TiScritpItem>> listScriptFile(String userEmail,
                                                       int projectId,
                                                       String scriptDesc,
                                                       int page,
                                                       int pageSize) {

        final TestInBaseRequest<Object> request = BaseRequestBuilder.builder()
                .withApikey(testInConfig.getApiKey())
                .withMkey(SCRIPT)
                .withOp(ApiOptions.Script.LIST_SCRIPT_FILE)
                .withData(ReqMapDataBuilder.builder()
                        .withUser(userEmail)
                        .withStartPageNo(page)
                        .withPageSize(pageSize)
                        .withParam(PROJECT_ID, projectId)
                        .withParam(SCRIPT_DESC, scriptDesc)
                        .build())
                .withAction(SCRIPT)
                .build();
        ParameterizedTypeReference<TestInBaseRespond<PageData<List<TiScritpItem>>>> reference =
                new ParameterizedTypeReference<TestInBaseRespond<PageData<List<TiScritpItem>>>>() {
                };

        final ResponseEntity<TestInBaseRespond<PageData<List<TiScritpItem>>>> responseEntity = restTemplate.exchange(testInConfig.getBaseApiUrl(), HttpMethod.POST, new HttpEntity<>(request), reference);
        LogUtil.info("获取云测项目脚本列表响应：{}", responseEntity);
        final TestInBaseRespond<PageData<List<TiScritpItem>>> respond = responseEntity.getBody();
        if (respond == null || !respond.isSuccess()) {
            String errMsg = respond != null ? respond.getMsg() : "";
            MSException.throwException("访问云测接口失败: " + errMsg);
        }
        return respond.getData();
    }
}
