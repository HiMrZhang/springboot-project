package com.easysoft.project.service.impl;

import com.easysoft.project.base.BaseDao;
import com.easysoft.project.base.BaseServiceImpl;
import com.easysoft.project.dao.UserMapper;
import com.easysoft.project.entity.User;
import com.easysoft.project.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO
 *
 * @author： zyp[2305658511@qq.com]
 * @date： 2019-04-22 17:30
 * @version： V1.0
 * @review: zyp[2305658511@qq.com]/2019-04-22 17:30
 */
@Service
@Slf4j
public class DemoServiceImpl extends BaseServiceImpl implements DemoService {
    @Autowired
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public String sayHello(String name) {
        log.info("info");
        log.debug("debug");
        return "Hello " + name;
    }

    @Transactional
    public Integer save(User user) {
        return userMapper.insert(user);
    }

    @Override
    public BaseDao getDaoMapper() {
        return userMapper;
    }
}