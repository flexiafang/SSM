package test;

import config.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.AccountService;

/**
 * @Author hustffx
 * @Date 2020/6/17 22:35
 */
public class AOPTest {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountService as = ac.getBean("accountService", AccountService.class);
        as.saveAccount();
    }
}
