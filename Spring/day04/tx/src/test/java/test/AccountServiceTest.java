package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.AccountService;

/**
 * 使用junit单元测试：测试配置
 *
 * @Author hustffx
 * @Date 2020/6/15 19:03
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    @Qualifier("accountService")
    private AccountService as;

    @Test
    public void testTransfer() {
        as.transfer("aaa", "bbb", 500F);
    }
}
