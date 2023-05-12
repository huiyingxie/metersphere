package io.metersphere.testin.controller;

import io.metersphere.commons.utils.Pager;
import io.metersphere.testin.controller.request.ProjectBindReq;
import io.metersphere.testin.controller.request.ScriptBindReq;
import io.metersphere.testin.domain.TestInProjectBind;
import io.metersphere.testin.domain.TestInScriptBind;
import io.metersphere.testin.dto.TiProjectItem;
import io.metersphere.testin.dto.TiScritpItem;
import io.metersphere.testin.service.TestInService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * TestIn 云测项目 Controller
 *
 * @author maguangming
 * @since 2023/5/10 14:09
 */
@RestController
@RequestMapping(value = "testIn")
public class TestInController {

    @Resource
    private TestInService testInService;

    @GetMapping("project/list/{goPage}/{pageSize}")
    public Pager<List<TiProjectItem>> getProjectList(@PathVariable int goPage, @PathVariable int pageSize) {
        return testInService.getProjectList(goPage, pageSize);
    }

    @PostMapping("project/bind")
    public void bindProject(@RequestBody ProjectBindReq req) {
        testInService.bindProject(req);
    }

    @GetMapping("project/getBind")
    public TestInProjectBind getBindProject(String msProjectId) {
        return testInService.getBindProject(msProjectId);
    }

    @GetMapping("script/list/{goPage}/{pageSize}")
    public Pager<List<TiScritpItem>> getScriptList(@PathVariable int goPage,
                                                   @PathVariable int pageSize,
                                                   @RequestParam String msProjectId,
                                                   @RequestParam(required = false) String scriptDesc) {
        return testInService.getScriptList(msProjectId, scriptDesc, goPage, pageSize);
    }

    @PostMapping("script/bind")
    public void bindScript(@RequestBody ScriptBindReq req) {
        testInService.bindScript(req);
    }

    @GetMapping("script/getBind")
    public TestInScriptBind getBindScript(String msCaseId) {
        return testInService.getBindScript(msCaseId);
    }
}
