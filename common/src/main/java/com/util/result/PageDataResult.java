package com.util.result;

/**
 * @author lee
 * @Date:28/02/2018
 */

public class PageDataResult extends DataResult {

    private Integer pageIndex;

    private Integer pageNum;

    private Long len;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Long getLen() {
        return len;
    }

    public void setLen(Long len) {
        this.len = len;
    }
}
