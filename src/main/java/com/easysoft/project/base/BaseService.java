package com.easysoft.project.base;


import com.easysoft.project.util.MybatisQueryHelper;
import com.easysoft.project.util.PageBean;

public interface BaseService {
    //进行分页查询
    PageBean getPageBean(Integer pageNum, Integer pageSize, MybatisQueryHelper queryHelper);
}
