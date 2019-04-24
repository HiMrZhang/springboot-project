package com.easysoft.project.controller;

import com.easysoft.project.entity.User;
import com.easysoft.project.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * TODO
 *
 * @author： zyp[2305658511@qq.com]
 * @date： 2019-04-22 17:30
 * @version： V1.0
 * @review: zyp[2305658511@qq.com]/2019-04-22 17:30
 */
@Controller
@Slf4j
public class DemoController {
    @Autowired
    DemoService demoService;

    @ResponseBody
    @GetMapping("/hello")
    public String hello(@RequestParam String nickName, @RequestParam String phoneNumber) {
        log.debug("debug");
        log.info("info");
        User user = new User();
        user.setNickName(nickName);
        user.setCreateTime(new Date());
        user.setPhoneNumber(phoneNumber);
        demoService.save(user);
        return "hello word";
    }

    @GetMapping("/")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "http://soft.ganen521.com");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }
}
