package io.metersphere.testin.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.metersphere.base.domain.TestPlanTestCaseExample;
import io.metersphere.base.domain.TestPlanTestCaseWithBLOBs;
import io.metersphere.base.mapper.TestInProjectBindMapper;
import io.metersphere.base.mapper.TestInScriptBindMapper;
import io.metersphere.base.mapper.TestPlanTestCaseMapper;
import io.metersphere.commons.constants.TestPlanTestCaseStatus;
import io.metersphere.commons.exception.MSException;
import io.metersphere.commons.utils.LogUtil;
import io.metersphere.config.TestInConfig;
import io.metersphere.testin.domain.TestInScriptBind;
import io.metersphere.testin.dto.TaskReportData;
import io.metersphere.testin.manager.ReportManager;
import io.metersphere.testin.manager.TaskManager;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Describe
 *
 * @author maguangming
 * @since 2023/5/12 14:23
 */
@Service
public class TestInTaskService {

    public static final String TASK_ACTION = "action";
    /**
     * 查询TestIn执行结果列表状态列表分页大小
     */
    public static final int FETCH_REPORT_LIST_PAGE_SIZE = 200;
    @Resource
    private ReportManager reportManager;

    @Resource
    private TestInConfig testInConfig;

    @Resource
    private TestInProjectBindMapper projectBindMapper;

    @Resource
    TestPlanTestCaseMapper testPlanTestCaseMapper;

    @Resource
    private TestInScriptBindMapper scriptBindMapper;


    public void dealCallBack(String callBackData) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode callBackJsonNode = null;
        try {
            callBackJsonNode = objectMapper.readTree(callBackData);
        } catch (JsonProcessingException e) {
            MSException.throwException(e);
        }
        if (!callBackJsonNode.has(TASK_ACTION)) {
            MSException.throwException("taskAction unrecognized ");
        }
        final String taskAction = callBackJsonNode.get(TASK_ACTION).asText();
        LogUtil.info("TestIn callback taskAction:" + taskAction);
        if ("complete".equals(taskAction)) {
            //任务完成
            final JsonNode content = callBackJsonNode.get("content");
            String taskId = content.get("taskid").asText();
            int projectId = content.has("projectid") ? content.get("projectid").asInt() : 1;
            updatePlanCaseStatus(taskId, projectId);
        }

    }

    /**
     * 查询TestIn任务执行结果状态，然后更新测试计划用例状态
     *
     * @param taskId    TestIn taskId
     * @param projectId TestIn projectId
     */
    public void updatePlanCaseStatus(String taskId, int projectId) {
        // TODO: 2023/5/12
        boolean haveNextPage = true;
        String userEmail = testInConfig.getDefaultQueryUserMail();
        int page = 1;
        while (haveNextPage) {
            final TaskReportData taskReportData = reportManager.list(userEmail, projectId, taskId, page, FETCH_REPORT_LIST_PAGE_SIZE);
            for (TaskReportData.ListDTO listDTO : taskReportData.getList()) {
                final Integer scriptNo = listDTO.getReportScript().getScriptNo();
                final TestInScriptBind scriptBind = scriptBindMapper.findByScriptNo(scriptNo);
                if (scriptBind != null) {
                    TestPlanTestCaseExample caseExample = new TestPlanTestCaseExample();
                    caseExample.createCriteria().andCaseIdEqualTo(scriptBind.getMsCaseId());
                    final List<TestPlanTestCaseWithBLOBs> caseWithBLOBsList = testPlanTestCaseMapper.selectByExampleWithBLOBs(caseExample);
                    if (caseWithBLOBsList.size() > 0) {
                        String caseStatus = TestPlanTestCaseStatus.Pass.name();
                        if (listDTO.getResultCategory() != 1) {
                            //Test in 脚本状态 1 通过，其它为各种失败状态
                            caseStatus = TestPlanTestCaseStatus.Failure.name();
                        }
                        final TestPlanTestCaseWithBLOBs planTestCase = caseWithBLOBsList.get(0);
                        planTestCase.setStatus(caseStatus);
                        planTestCase.setUpdateTime(System.currentTimeMillis());
                        testPlanTestCaseMapper.updateByPrimaryKeySelective(planTestCase);
                    }

                }
            }
            if (taskReportData.getTotalPage() <= page) {
                haveNextPage = false;
            }
            page++;
        }

    }
}
