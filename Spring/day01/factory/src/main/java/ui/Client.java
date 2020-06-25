package ui;

import factory.BeanFactory;
import service.AccountService;

/**
 * @Author hustffx
 * @Date 2020/6/13 15:07
 */
public class Client {
    public static void main(String[] args) {
        AccountService as;
        for (int i = 0; i < 5; i++) {
            as = (AccountService) BeanFactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }
    }
}
