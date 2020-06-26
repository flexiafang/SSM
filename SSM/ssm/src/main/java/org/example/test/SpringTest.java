package org.example.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.example.service.AccountService;

/**
 * @Author hustffx
 * @Date 2020/6/26 11:08
 */
public class SpringTest {
    @Test
    public void run() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        AccountService as = ac.getBean("accountService", AccountService.class);
        as.findAll();
    }
}
