package com.easysoft.project.base;

import com.easysoft.project.util.MybatisQueryHelper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.io.Serializable;
import java.util.List;

/**
 * TODO
 *
 * @author： zyp[2305658511@qq.com]
 * @date： 2019-04-22 17:30
 * @version： V1.0
 * @review: zyp[2305658511@qq.com]/2019-04-22 17:30
 */
public interface BaseDao<T> {
    int countByExample(MybatisQueryHelper example);

    int deleteByExample(MybatisQueryHelper example);

    int deleteByPrimaryKey(Serializable id);

    int insert(T record);

    int insertSelective(T record);

    List<T> selectByExample(MybatisQueryHelper example, RowBounds rowBounds);

    List<T> selectByExample(MybatisQueryHelper example);

    T selectByPrimaryKey(Serializable id);

    int updateByExampleSelective(@Param("record") T record,
                                 @Param("example") MybatisQueryHelper example);

    int updateByExample(@Param("record") T record, @Param("example") MybatisQueryHelper example);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
