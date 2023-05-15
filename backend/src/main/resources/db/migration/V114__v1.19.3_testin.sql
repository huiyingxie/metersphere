-- test_in_project_bind definition

CREATE TABLE test_in_project_bind
(
    id                   varchar(50) NOT NULL,
    ms_project_id        varchar(50) NOT NULL,
    test_in_project_id   int         NOT NULL,
    test_in_project_name varchar(256) NULL,
    create_time          bigint NULL,
    creator              varchar(100) NULL,
    update_time          bigint(100) NULL,
    update_user          varchar(100) NULL,
    del_flag             tinyint NULL,
    del_time             bigint NULL,
    CONSTRAINT test_in_project_bind_pk PRIMARY KEY (id)
) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci
COMMENT='TestIn项目绑定';
CREATE INDEX test_in_project_bind_ms_project_id_IDX USING BTREE ON test_in_project_bind (ms_project_id);

-- test_in_project_bind definition

CREATE TABLE test_in_script_bind
(
    id                  varchar(50) NOT NULL,
    ms_case_id          varchar(50) NOT NULL,
    test_in_script_no   int         NOT NULL,
    test_in_script_name varchar(256) NULL,
    cover_install       tinyint NULL,
    clean_data          tinyint NULL,
    keep_app            tinyint NULL,
    create_time         bigint NULL,
    creator             varchar(100) NULL,
    update_time         bigint(100) NULL,
    update_user         varchar(100) NULL,
    del_flag            tinyint NULL,
    del_time            bigint NULL,
    CONSTRAINT test_in_project_bind_pk PRIMARY KEY (id)
) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci
COMMENT='TestIn项目绑定';
CREATE INDEX test_in_script_bind_ms_project_id_IDX USING BTREE ON test_in_project_bind (ms_project_id);
