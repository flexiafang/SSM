package ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.AccountService;

/**
 * @Author hustffx
 * @Date 2020/6/13 15:07
 */
public class Client {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        AccountService as1 = (AccountService) ac.getBean("accountService");
        as1.saveAccount();

        AccountService as2 = (AccountService) ac.getBean("accountService2");
        as2.saveAccount();

        AccountService as3 = (AccountService) ac.getBean("accountService3");
        as3.saveAccount();
    }
}
