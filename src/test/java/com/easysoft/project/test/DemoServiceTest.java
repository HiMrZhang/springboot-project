package com.easysoft.project.test;

import com.easysoft.project.entity.User;
import com.easysoft.project.service.DemoService;
import org.junit.Assert;
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
public class DemoServiceTest extends BaseTest {

    @Autowired
    private DemoService demoService;

    @Test
    public void save() {
        User user = new User();
        user.setPhoneNumber("18888888888");
        Assert.assertEquals(1, demoService.save(user).intValue());
    }

    @Test
    public void sayHello() {
        Assert.assertEquals("Hello zyp", demoService.sayHello("zyp"));
    }

}
