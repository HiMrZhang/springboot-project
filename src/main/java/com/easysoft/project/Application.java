package com.easysoft.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * TODO
 *
 * @author： zyp[2305658511@qq.com]
 * @date： 2019-04-22 17:30
 * @version： V1.0
 * @review: zyp[2305658511@qq.com]/2019-04-22 17:30
 */
@SpringBootApplication(scanBasePackages = {"com.easysoft.project"})
@EnableTransactionManagement
@MapperScan("com.easysoft.project.dao")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
