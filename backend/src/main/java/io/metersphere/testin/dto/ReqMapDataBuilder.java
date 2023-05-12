package io.metersphere.testin.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;

/**
 * Describe
 *
 * @author maguangming
 * @since 2023/5/10 9:14
 */
@Getter
@Setter
public class ReqMapDataBuilder {

    public static final String ONLINE_USER_INFO = "onlineUserInfo";
    public static final String PAGE_SIZE = "pageSize";
    public static final String PAGE = "page";
    public static final String START_PAGE_NO = "startPageNo";
    protected LinkedHashMap<String, Object> dataMap;
    protected OnlineUserInfoDTO onlineUserInfo;

    private ReqMapDataBuilder() {
    }

    public static ReqMapDataBuilder builder() {
        final ReqMapDataBuilder dataBuilder = new ReqMapDataBuilder();
        dataBuilder.dataMap = new LinkedHashMap<>();
        return dataBuilder;
    }

    public LinkedHashMap<String, Object> build() {
        return dataMap;
    }


    public ReqMapDataBuilder withUser(String email) {
        return withUser(email, null);
    }

    public ReqMapDataBuilder withUser(String email, Integer projectId) {
        final OnlineUserInfoDTO onlineUserInfoDTO = new OnlineUserInfoDTO(email, projectId);
        dataMap.put(ONLINE_USER_INFO, onlineUserInfoDTO);
        return this;
    }

    public ReqMapDataBuilder withParam(String key, Object value) {
        dataMap.put(key, value);
        return this;
    }

    public ReqMapDataBuilder withPageSize(int pageSize) {
        dataMap.put(PAGE_SIZE, pageSize);
        return this;
    }

    public ReqMapDataBuilder withPage(int page) {
        dataMap.put(PAGE, page);
        return this;
    }

    public ReqMapDataBuilder withStartPageNo(int page) {
        dataMap.put(START_PAGE_NO, page);
        return this;
    }
}
