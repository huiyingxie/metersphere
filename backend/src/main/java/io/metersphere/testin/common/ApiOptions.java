package io.metersphere.testin.common;

/**
 * Describe
 *
 * @author maguangming
 * @since 2023/5/10 14:37
 */
public interface ApiOptions {

    interface Project {
        String GET_PROJECT_LIST = "Project.getProjectList";
    }

    interface Script {
        String LIST_SCRIPT_FILE = "Script.listScriptFile";
    }

    interface Task {
        String INIT_DATA = "Task.initData";
    }

    interface User {
        String GET_TOKEN = "User.getToken";
    }

    interface Report {
        String LIST = "Report.list";
    }
}
