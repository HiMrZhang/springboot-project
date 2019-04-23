package com.easysoft.project.util;

/**
 * TODO
 *
 * @author： zyp[2305658511@qq.com]
 * @date： 2019-04-22 17:30
 * @version： V1.0
 * @review: zyp[2305658511@qq.com]/2019-04-22 17:30
 */
public class PageUtil {
    @Override
    public String toString() {
        return "PageUtil [currentPage=" + currentPage + ", pageSize="
                + pageSize + ", recordCount=" + recordCount + ", pageCount="
                + pageCount + ", beginPageIndex=" + beginPageIndex
                + ", endPageIndex=" + endPageIndex + "]";
    }

    private int currentPage;
    private int pageSize;
    private int recordCount;
    private int pageCount;
    private int beginPageIndex;
    private int endPageIndex;

    public PageUtil() {
    }


    public PageUtil(int currentPage, int pageSize) {
        super();
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }


    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getBeginPageIndex() {
        return beginPageIndex;
    }

    public void setBeginPageIndex(int beginPageIndex) {
        this.beginPageIndex = beginPageIndex;
    }

    public int getEndPageIndex() {
        return endPageIndex;
    }

    public void setEndPageIndex(int endPageIndex) {
        this.endPageIndex = endPageIndex;
    }
}