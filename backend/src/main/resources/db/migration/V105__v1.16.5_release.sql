ALTER TABLE test_plan_report_content ADD plan_scenario_report_struct longtext NULL;
ALTER TABLE test_plan_report_content ADD plan_api_case_report_struct longtext NULL;
ALTER TABLE test_plan_report_content ADD plan_load_case_report_struct longtext NULL;
ALTER TABLE api_execution_queue ADD failure TINYINT(1);

CREATE INDEX api_scenario_report_result_report_id_IDX ON api_scenario_report_result (report_id);

-- 平台同步数据
CREATE TABLE IF NOT EXISTS `platform_data` (
                                 `id` varchar(50) DEFAULT NULL,
                                 `record_id` varchar(50) DEFAULT NULL,
                                 `platform` varchar(100) DEFAULT NULL COMMENT 'platform key: Jira,...',
                                 `platform_id` varchar(50) DEFAULT NULL,
                                 `platform_data` longtext COMMENT 'platform raw fields data'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_general_ci;
