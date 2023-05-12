package io.metersphere.testin.controller;

import io.metersphere.commons.utils.LogUtil;
import io.metersphere.testin.controller.request.StartTaskInitReq;
import io.metersphere.testin.service.TestInService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.LinkedHashMap;

/**
 * TestIn 云测项目 Controller
 *
 * @author maguangming
 * @since 2023/5/10 14:09
 */
@RestController
@RequestMapping(value = "testIn/task")
public class TestInTaskController {

    @Resource
    private TestInService testInService;

    @PostMapping("startInitData")
    public String startInit(@RequestBody StartTaskInitReq req) {
        return testInService.startTask(req);
    }

    @PostMapping("callback")
    public String getProjectList(@RequestBody LinkedHashMap<String, Object> request) {
        LogUtil.info(request);
        // TODO: 2023/5/12
        System.out.println("testIn callback data: " + request);
        return "ok";
    }
}
