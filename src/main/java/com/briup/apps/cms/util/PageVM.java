package com.briup.apps.cms.util;

import java.util.List;

/**
 * @Atuhor: qin
 * @Create: 2019-12-23-10-34
 * @Time: 10:34
 * @Description:
 */
public class PageVM<T> {
    private Long total;
    private Integer page;
    private Integer pageSize;
    private List<T> list;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
