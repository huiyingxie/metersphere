package io.metersphere.testin.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * Describe
 *
 * @author maguangming
 * @since 2023/5/10 9:18
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PageStatusReq extends OnlineUserData {
    private int page;
    private int pageSize;
    private int status;

    public PageStatusReq(int page, int pageSize, int status) {
        this.page = page;
        this.pageSize = pageSize;
        this.status = status;
    }
}
