package io.metersphere.commons.utils;

import com.github.pagehelper.Page;
import io.metersphere.testin.dto.PageData;

public class PageUtils {
    public static <T> Pager<T> setPageInfo(Page page, T obj) {
        try {
            Pager<T> pager = new Pager<>();
            pager.setListObject(obj);
            pager.setPageCount(page.getPages());
            pager.setItemCount(page.getTotal());
            return pager;
        } catch (Exception e) {
            throw new RuntimeException("Error saving current page number data！");
        }
    }

    public static <T> Pager<T> setPageInfo(PageData<T> page) {
        try {
            Pager<T> pager = new Pager<>();
            pager.setListObject(page.getList());
            pager.setPageCount(page.getTotalPage());
            pager.setItemCount(page.getTotalRow());
            return pager;
        } catch (Exception e) {
            throw new RuntimeException("Error saving current page number data！");
        }
    }
}
