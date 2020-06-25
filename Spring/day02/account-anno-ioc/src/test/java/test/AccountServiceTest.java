package test;

import domain.Account;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.AccountService;

import java.util.List;

/**
 * 使用junit单元测试：测试配置
 *
 * @Author hustffx
 * @Date 2020/6/15 19:03
 */
public class AccountServiceTest {
    private AccountService as;

    @Before
    public void setUp() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        as = ac.getBean("accountService", AccountService.class);
    }

    @Test
    public void testFindAll() {
        List<Account> accounts = as.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
        Account account = as.findById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("test");
        account.setMoney(1234F);
        as.save(account);
    }

    @Test
    public void testUpdate() {
        Account account = as.findById(4);
        account.setMoney(2345F);
        as.update(account);
    }

    @Test
    public void testDelete() {
        as.delete(4);
    }
}
