package test;

import dao.AccountDao;
import dao.UserDao;
import domain.Account;
import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author hustffx
 * @Date 2020/6/11 0:31
 */
public class AccountTest {
    private InputStream config;
    private SqlSession session;
    private AccountDao mapper;

    @Before
    public void setUp() throws IOException {
        config = Resources.getResourceAsStream("SqlMapConfig.xml");
        session = new SqlSessionFactoryBuilder().build(config).openSession();
        mapper = session.getMapper(AccountDao.class);
    }

    @After
    public void tearDown() throws IOException {
        session.commit();
        session.close();
        config.close();
    }

    @Test
    public void testFindAll() {
        List<Account> accounts = mapper.findAll();
        for (Account account : accounts) {
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }
}
