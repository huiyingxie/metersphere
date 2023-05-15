package io.metersphere.base.mapper;

import io.metersphere.testin.domain.TestInScriptBind;
import org.apache.ibatis.annotations.Param;

/**
 * Describe
 *
 * @author maguangming
 * @since 2023/5/11 17:39
 */
public interface TestInScriptBindMapper {

    int insert(TestInScriptBind record);

    int delete(@Param("id") String id, @Param("updateUser") String updateUser);

    TestInScriptBind findByMsCaseId(String msCaseId);
    TestInScriptBind findByScriptNo(Integer scriptNo);
}
