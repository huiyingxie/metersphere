package io.metersphere.testin.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Describe
 *
 * @author maguangming
 * @since 2023/5/10 10:52
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PageData <T>{

    private long totalRow;

    private long totalPage;

    private long pageSize;

    private long page;

    private T list;

    public long getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(long totalRow) {
        this.totalRow = totalRow;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public T getList() {
        return list;
    }

    public void setList(T list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageData{" +
                "totalRow=" + totalRow +
                ", totalPage=" + totalPage +
                ", pageSize=" + pageSize +
                ", page=" + page +
                ", list=" + list +
                '}';
    }
}
