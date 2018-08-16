package com.util.page;

/**
 * @author lee
 * @Date 28/02/2018
 */

public class Page {

    /**
     * 页码 默认值为1
     */
    private Integer pageIndex;

    /**
     * 每页记录条数 默认为10
     */
    private Integer pageSize;

    public static void main(String[] args) {
        Page page = new Page();
        page.setPageIndex(2);
        page.setPageSize(0);
        System.out.println(page.getStartIndex());
    }

    public Integer getPageIndex() {
        return pageIndex == null || pageIndex < 1 ? 0 : (pageIndex - 1);
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize == null || pageSize == 0 ? 10 : pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStartIndex() {
        return getPageIndex() * getPageSize();
    }
}
