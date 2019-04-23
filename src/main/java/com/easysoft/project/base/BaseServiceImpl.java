package com.easysoft.project.base;


import com.easysoft.project.util.MybatisQueryHelper;
import com.easysoft.project.util.PageBean;

public abstract class BaseServiceImpl implements BaseService {

    public PageBean getPageBean(Integer pageNum, Integer pageSize, MybatisQueryHelper queryHelper) {
        return PageBean.getPageBean(pageNum, pageSize, getDaoMapper(), queryHelper);
    }

    public abstract BaseDao getDaoMapper();

}
