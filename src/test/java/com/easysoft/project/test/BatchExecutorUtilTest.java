package com.easysoft.project.test;

import com.easysoft.project.dao.UserMapper;
import com.easysoft.project.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * TODO
 *
 * @author： zyp[2305658511@qq.com]
 * @date： 2019-04-22 17:30
 * @version： V1.0
 * @review: zyp[2305658511@qq.com]/2019-04-22 17:30
 */
public class BatchExecutorUtilTest extends BaseTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testBatchInsert() {
        User user = new User();
        user.setNickName("zyp");
        userMapper.insert(user);
    }

}
