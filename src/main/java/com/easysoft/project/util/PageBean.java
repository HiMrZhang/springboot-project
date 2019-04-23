package com.easysoft.project.util;
import com.easysoft.project.base.BaseDao;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * 封装分页显示的信息
 *
 * @author： zyp[2305658511@qq.com]
 * @date： 2019-04-22 17:30
 * @version： V1.0
 * @review: zyp[2305658511@qq.com]/2019-04-22 17:30
 */
public class PageBean {

    // 查询数据库
    private List recordList;
    // 本页的数据列表
    private PageUtil data = new PageUtil();

    /**
     * 只接受4个必要的属性，会自动的计算出其他3个属性的值
     *
     * @param currentPage
     * @param pageSize
     * @param recordList
     * @param recordCount
     */
    public PageBean(Integer currentPage, int pageSize, List recordList, int recordCount) {
        this.data.setCurrentPage(currentPage);
        this.data.setPageSize(pageSize);
        this.recordList = recordList;
        this.data.setRecordCount(recordCount);

        // 计算 pageCount
        data.setPageCount((recordCount + pageSize - 1) / pageSize);

        // 计算 beginPageIndex 与 endPageIndex
        // >> 总页码小于等于10页时，全部显示
        if (data.getPageCount() <= 10) {
            data.setBeginPageIndex(1);
            data.setEndPageIndex(data.getPageCount());
        }
        // >> 总页码大于10页时，就只显示当前页附近的共10个页码
        else {
            // 默认显示 前4页 + 当前页 + 后5页
            data.setBeginPageIndex(currentPage - 4); // 7 - 4 = 3;
            data.setEndPageIndex(currentPage + 5); // 7 + 5 = 12; --> 3 ~ 12

            // 如果前面不足4个页码时，则显示前10页
            if (data.getBeginPageIndex() < 1) {
                data.setBeginPageIndex(1);
                data.setEndPageIndex(10);
            }
            // 如果后面不足5个页码时，则显示后10页
            else if (data.getEndPageIndex() > data.getPageCount()) {
                data.setEndPageIndex(data.getPageCount());
                data.setBeginPageIndex(data.getPageCount() - 9);
            }
        }
    }

    public List getRecordList() {
        return recordList;
    }

    public void setRecordList(List recordList) {
        this.recordList = recordList;
    }

    public int getCurrentPage() {
        return data.getCurrentPage();
    }

    public void setCurrentPage(int currentPage) {
        this.data.setCurrentPage(currentPage);
    }

    public int getPageCount() {
        return data.getPageCount();
    }

    public void setPageCount(int pageCount) {
        this.data.setPageCount(pageCount);
    }

    public int getPageSize() {
        return data.getPageSize();
    }

    public void setPageSize(int pageSize) {
        this.data.setPageSize(pageSize);
    }

    public int getRecordCount() {
        return data.getRecordCount();
    }

    public void setRecordCount(int recordCount) {
        this.data.setRecordCount(recordCount);
    }

    public int getBeginPageIndex() {
        return data.getBeginPageIndex();
    }

    public void setBeginPageIndex(int beginPageIndex) {
        this.data.setBeginPageIndex(beginPageIndex);
    }

    public int getEndPageIndex() {
        return data.getEndPageIndex();
    }

    public void setEndPageIndex(int endPageIndex) {
        this.data.setEndPageIndex(endPageIndex);
    }

    /**
     * 获取分页的信息，更给service层调用
     *
     * @param pageNum
     * @param queryHelper
     * @return
     * @author zyp
     * @date 2014-8-14
     */
    public static PageBean getPageBean(Integer pageNum, Integer pageSize, BaseDao baseDao, MybatisQueryHelper queryHelper) {
        //默认的当前页为1
        pageNum = (pageNum == null || pageNum < 1) ? 1 : pageNum;
        pageSize = (pageSize == null || pageSize < 1) ? Constants.DEFAULT_PAGESIZE : pageSize;
        // 查询总记录数
        int count = baseDao.countByExample(queryHelper);// 执行查询
        // 查询本页的数据列表
        RowBounds rb = new RowBounds((pageNum - 1) * pageSize, pageSize);
        // 执行查询
        List list = baseDao.selectByExample(queryHelper, rb);
        return new PageBean(pageNum, pageSize, list, count);
    }
}
