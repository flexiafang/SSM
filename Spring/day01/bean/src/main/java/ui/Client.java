package ui;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.AccountService;

/**
 * @Author hustffx
 * @Date 2020/6/13 15:07
 */
public class Client {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService as = (AccountService) ac.getBean("accountService");
        as.saveAccount();
        ac.close();
    }
}
