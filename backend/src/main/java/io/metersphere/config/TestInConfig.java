package io.metersphere.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Describe
 *
 * @author maguangming
 * @since 2023/5/9 18:05
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "test-in")
public class TestInConfig {

    String appId = "testinpro";

    // FIXME: 2023/5/15
    String apiKey = "XXX";

    String baseApiUrl = "http://openapi.yc.qisi.ltd";

    String baseWebUrl = "http://test.yc.qisi.ltd";

    String ssoCallPath = "/sso/callback.htm";

    String suiteSelectPath = "http://test.yc.qisi.ltd/autotest/suiteSelect.htm";

    String msCallBackUrl = "http://10.245.9.47:8081/testIn/task/callback";

    /**
     * 任务报告状态查询接口需要用户邮箱
     */
    String defaultQueryUserMail = "zhulin29@faw.com.cn";
}
