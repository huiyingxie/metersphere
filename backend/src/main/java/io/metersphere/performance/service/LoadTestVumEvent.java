package io.metersphere.performance.service;

import io.metersphere.base.domain.*;
import io.metersphere.base.mapper.LoadTestReportMapper;
import io.metersphere.base.mapper.ext.ExtLoadTestReportMapper;
import io.metersphere.commons.constants.PerformanceTestStatus;
import io.metersphere.commons.constants.ReportKeys;
import io.metersphere.commons.consumer.LoadTestFinishEvent;
import io.metersphere.commons.utils.CommonBeanFactory;
import io.metersphere.commons.utils.LogUtil;
import io.metersphere.performance.base.VumProcessedStatus;
import io.metersphere.service.QuotaService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author lyh
 */

@Component
public class LoadTestVumEvent implements LoadTestFinishEvent {
    @Resource
    private LoadTestReportMapper loadTestReportMapper;
    @Resource
    private ExtLoadTestReportMapper extLoadTestReportMapper;
    @Resource
    private RedissonClient redissonClient;

    private void handleVum(LoadTestReport report) {
        if (report == null) {
            return;
        }

        LoadTestReportWithBLOBs testReport = loadTestReportMapper.selectByPrimaryKey(report.getId());
        if (testReport == null) {
            return;
        }

        int bl = extLoadTestReportMapper.updateReportVumStatus(report.getId(),
                ReportKeys.VumProcessedStatus.name(),
                VumProcessedStatus.PROCESSED,
                VumProcessedStatus.NOT_PROCESSED);

        // 防止重复处理
        if (bl == 0) {
            return;
        }

        QuotaService quotaService = CommonBeanFactory.getBean(QuotaService.class);
        String projectId = report.getProjectId();
        RLock lock = redissonClient.getLock(projectId);
        if (quotaService != null) {
            try {
                lock.lock();
                BigDecimal toReduceVum = quotaService.getReduceVumUsed(testReport);
                if (toReduceVum.compareTo(BigDecimal.ZERO) != 0) {
                    quotaService.updateVumUsed(projectId, toReduceVum.negate());
                }
            } finally {
                lock.unlock();
            }
        } else {
            LogUtil.error("handle vum event get quota service bean is null. load test report id: " + report.getId());
        }
    }

    @Override
    public void execute(LoadTestReport report) {
        if (PerformanceTestStatus.Error.name().equals(report.getStatus())) {
            // 失败后回退vum数量
            this.handleVum(report);
        }
    }
}
