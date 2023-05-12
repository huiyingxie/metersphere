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

/**
 * Describe
 *
 * @author maguangming
 * @since 2023/5/10 21:08
 */
@Component
public class UserManager {
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private TestInConfig testInConfig;

    public String getToken(String userEmail, Integer projectId) {
        TestInBaseRequest<Object> request = BaseRequestBuilder.builder()
                .withApikey(testInConfig.getApiKey())
                .withMkey("UserManager")
                .withAction("user")
                .withOp(ApiOptions.User.GET_TOKEN)
                .withData(ReqMapDataBuilder.builder().withUser(userEmail, projectId).build())
                .build();
        ParameterizedTypeReference<TestInBaseRespond<ResultDto>> reference =
                new ParameterizedTypeReference<TestInBaseRespond<ResultDto>>() {
                };

        final ResponseEntity<TestInBaseRespond<ResultDto>> responseEntity = restTemplate.exchange(testInConfig.getBaseApiUrl(), HttpMethod.POST, new HttpEntity<>(request), reference);
        LogUtil.info("获取云测用户Token响应：{}", responseEntity);
        final TestInBaseRespond<ResultDto> respond = responseEntity.getBody();
        if (respond == null || !respond.isSuccess()) {
            String errMsg = respond != null ? respond.getMsg() : "";
            MSException.throwException("访问云测接口失败: " + errMsg);
        }
        return respond.getData().getResult();
    }
}
