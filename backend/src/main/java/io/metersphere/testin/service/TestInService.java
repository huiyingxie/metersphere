package io.metersphere.testin.service;

import io.metersphere.base.domain.TestPlanTestCase;
import io.metersphere.base.domain.TestPlanTestCaseExample;
import io.metersphere.base.domain.TestPlanWithBLOBs;
import io.metersphere.base.mapper.TestInProjectBindMapper;
import io.metersphere.base.mapper.TestInScriptBindMapper;
import io.metersphere.base.mapper.TestPlanMapper;
import io.metersphere.base.mapper.TestPlanTestCaseMapper;
import io.metersphere.commons.exception.MSException;
import io.metersphere.commons.user.SessionUser;
import io.metersphere.commons.utils.PageUtils;
import io.metersphere.commons.utils.Pager;
import io.metersphere.commons.utils.SessionUtils;
import io.metersphere.config.TestInConfig;
import io.metersphere.testin.controller.request.ProjectBindReq;
import io.metersphere.testin.controller.request.ScriptBindReq;
import io.metersphere.testin.controller.request.StartTaskInitReq;
import io.metersphere.testin.domain.TestInProjectBind;
import io.metersphere.testin.domain.TestInScriptBind;
import io.metersphere.testin.dto.PageData;
import io.metersphere.testin.dto.TiProjectItem;
import io.metersphere.testin.dto.TiScritpItem;
import io.metersphere.testin.manager.ProjectManager;
import io.metersphere.testin.manager.ScriptManager;
import io.metersphere.testin.manager.TaskManager;
import io.metersphere.testin.manager.UserManager;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Describe
 *
 * @author maguangming
 * @since 2023/5/10 14:12
 */
@Service
public class TestInService {

    public static final int BIZ_CODE_FUNC = 4001;
    @Resource
    private ProjectManager projectManager;

    @Resource
    private TaskManager taskManager;

    @Resource
    private TestInConfig testInConfig;

    @Resource
    private ScriptManager scriptManager;

    @Resource
    private UserManager userManager;

    @Resource
    private TestInProjectBindMapper projectBindMapper;

    @Resource
    private TestInScriptBindMapper scriptBindMapper;

    @Resource
    private TestPlanMapper testPlanMapper;

    @Resource
    private TestPlanTestCaseMapper testPlanTestCaseMapper;

    public Pager<List<TiProjectItem>> getProjectList(int goPage, int pageSize) {
        final SessionUser user = SessionUtils.getUser();
        if (user == null || StringUtils.isEmpty(user.getEmail())) {
            MSException.throwException("获取登录用户异常");
        }
        PageData<List<TiProjectItem>> projectPageData = projectManager.getProjectList(user.getEmail(), goPage, pageSize);
        return PageUtils.setPageInfo(projectPageData);
    }

    public String startTask(StartTaskInitReq req) {
        //默认无应用
        if (req.getNoApp() == null || req.getNoApp() < 0) {
            req.setNoApp(1);
        }
        final SessionUser user = SessionUtils.getUser();
        if (user == null || StringUtils.isEmpty(user.getEmail())) {
            MSException.throwException("获取登录用户异常");
        }
        final TestPlanWithBLOBs testPlanWithBLOBs = testPlanMapper.selectByPrimaryKey(req.getMsTestPlanId());
        if (testPlanWithBLOBs == null) {
            MSException.throwException("测试计划不存在");
        }
        final TestInProjectBind projectBind = projectBindMapper.findByMsProjectId(testPlanWithBLOBs.getProjectId());
        if (projectBind == null || projectBind.getTestInProjectId() == null) {
            MSException.throwException("该用例所属项目未关联TestIn项目组");
        }
        final String taskDesc = "MS_" + testPlanWithBLOBs.getName() + "_" + System.currentTimeMillis();
        final List<Long> scriptsNoList = getPlanScriptsNoList(req.getMsTestPlanId());

        final String reqId = taskManager.initData(user.getEmail(), taskDesc, testInConfig.getMsCallBackUrl(),
                BIZ_CODE_FUNC, req.getNoApp(), scriptsNoList);
        System.out.println("reqId: " + reqId);
        final String token = userManager.getToken(user.getEmail(), projectBind.getTestInProjectId());
        String testTaskUrl = testInConfig.getBaseWebUrl() + testInConfig.getSsoCallPath();
        testTaskUrl += "?appId=" + testInConfig.getAppId();
        testTaskUrl += "&token=" + token;
        String suiteSelectPath = testInConfig.getSuiteSelectPath();
        suiteSelectPath += "?requestId=" + reqId;
        try {
            suiteSelectPath = URLEncoder.encode(suiteSelectPath, "UTF-8");
            testTaskUrl += "&refUrl=" + suiteSelectPath;
        } catch (UnsupportedEncodingException e) {
            MSException.throwException(e);
        }
        return testTaskUrl;
    }

    private List<Long> getPlanScriptsNoList(String testPlanId) {
        List<Long> scriptsNoList = new ArrayList<>();
        // TODO: 2023/5/12 联表查询 优化
        final TestPlanTestCaseExample example = new TestPlanTestCaseExample();
        example.createCriteria().andPlanIdEqualTo(testPlanId);
        final List<TestPlanTestCase> testPlanTestCases = testPlanTestCaseMapper.selectByExample(example);
        for (TestPlanTestCase planTestCase : testPlanTestCases) {
            final TestInScriptBind scriptBind = scriptBindMapper.findByMsCaseId(planTestCase.getCaseId());
            scriptsNoList.add(scriptBind.getTestInScriptNo());
        }

        return scriptsNoList;
    }

    @Transactional
    public void bindProject(ProjectBindReq req) {
        final TestInProjectBind findMsProject = projectBindMapper.findByMsProjectId(req.getMsProjectId());
        final String currentUser = SessionUtils.getUser().getId();
        if (findMsProject != null) {
            projectBindMapper.delete(findMsProject.getId(), currentUser);
        }
        TestInProjectBind projectBind = new TestInProjectBind();
        projectBind.setId(UUID.randomUUID().toString());
        projectBind.setMsProjectId(req.getMsProjectId());
        projectBind.setTestInProjectId(req.getTestInProjectId());
        projectBind.setTestInProjectName(req.getTestInProjectName());
        projectBind.setCreateTime(System.currentTimeMillis());
        projectBind.setUpdateTime(System.currentTimeMillis());
        projectBind.setCreator(currentUser);
        projectBindMapper.insert(projectBind);
    }

    public TestInProjectBind getBindProject(String msProjectId) {
        return projectBindMapper.findByMsProjectId(msProjectId);
    }

    public Pager<List<TiScritpItem>> getScriptList(String msProjectId, String scriptDesc, int goPage, int pageSize) {
        final TestInProjectBind projectBind = projectBindMapper.findByMsProjectId(msProjectId);
        if (projectBind == null || projectBind.getTestInProjectId() == null) {
            MSException.throwException("该用例所属项目未关联TestIn项目组");
        }
        final SessionUser user = SessionUtils.getUser();
        if (user == null || StringUtils.isEmpty(user.getEmail())) {
            MSException.throwException("获取登录用户异常");
        }
        final PageData<List<TiScritpItem>> listPageData = scriptManager.listScriptFile(user.getEmail(),
                projectBind.getTestInProjectId(), scriptDesc, goPage, pageSize);
        return PageUtils.setPageInfo(listPageData);
    }

    public void bindScript(ScriptBindReq req) {
        final TestInScriptBind findBind = scriptBindMapper.findByMsCaseId(req.getMsCaseId());
        final String currentUser = SessionUtils.getUser().getId();
        if (findBind != null) {
            scriptBindMapper.delete(findBind.getId(), currentUser);
        }
        final TestInScriptBind record = new TestInScriptBind();
        BeanUtils.copyProperties(req, record);
        record.setId(UUID.randomUUID().toString());
        record.setCreateTime(System.currentTimeMillis());
        record.setUpdateTime(System.currentTimeMillis());
        record.setCreator(currentUser);

        scriptBindMapper.insert(record);
    }

    public TestInScriptBind getBindScript(String msCaseId) {
        return scriptBindMapper.findByMsCaseId(msCaseId);
    }
}
