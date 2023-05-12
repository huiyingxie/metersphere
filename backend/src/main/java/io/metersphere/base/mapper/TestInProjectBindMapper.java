package io.metersphere.base.mapper;

import io.metersphere.base.domain.TestCaseTest;
import io.metersphere.testin.domain.TestInProjectBind;
import org.apache.ibatis.annotations.Param;

/**
 * Describe
 *
 *
 * @author maguangming
 * @since 2023/5/11 17:39
 */
public interface TestInProjectBindMapper {

    int insert(TestInProjectBind record);

    int delete(@Param("id") String id, @Param("updateUser") String updateUser);

    TestInProjectBind findByMsProjectId(String msProjectId);
}
