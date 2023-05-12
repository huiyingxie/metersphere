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
public class ProjectManager {
    //    public static final String URL = "";
    public static final int STATUS_DEFAULT = 1;
    public static final String USER_MANAGER = "usermanager";
    public static final String USER = "user";
    public static final String STATUS = "status";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private TestInConfig testInConfig;


    public PageData<List<TiProjectItem>> getProjectList(String userEmail, int page, int pageSize) {

        final TestInBaseRequest<Object> request = BaseRequestBuilder.builder()
                .withApikey(testInConfig.getApiKey())
                .withMkey(USER_MANAGER)
                .withOp(ApiOptions.Project.GET_PROJECT_LIST)
                .withData(new PageStatusReq(page, pageSize, STATUS_DEFAULT).buildUser(userEmail))
                .withData(ReqMapDataBuilder.builder()
                        .withUser(userEmail)
                        .withPage(page)
                        .withPageSize(pageSize)
                        .withParam(STATUS, STATUS_DEFAULT)
                        .build())
                .withAction(USER)
                .build();
        ParameterizedTypeReference<TestInBaseRespond<PageData<List<TiProjectItem>>>> reference =
                new ParameterizedTypeReference<TestInBaseRespond<PageData<List<TiProjectItem>>>>() {
                };

        final ResponseEntity<TestInBaseRespond<PageData<List<TiProjectItem>>>> responseEntity = restTemplate.exchange(testInConfig.getBaseApiUrl(), HttpMethod.POST, new HttpEntity<>(request), reference);
        LogUtil.info("获取云测项目列表响应：{}", responseEntity);
        final TestInBaseRespond<PageData<List<TiProjectItem>>> respond = responseEntity.getBody();
        if (respond == null || !respond.isSuccess()) {
            String errMsg = respond != null ? respond.getMsg() : "";
            MSException.throwException("访问云测接口失败: " + errMsg);
        }
        return respond.getData();
    }
}
