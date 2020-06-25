package test;

import dao.AccountDao;
import dao.UserDao;
import domain.Account;
import domain.AccountUser;
import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author hustffx
 * @Date 2020/6/5 17:10
 */
public class AccountTest {
    private InputStream config;
    private SqlSession session;
    private AccountDao mapper;

    @Before
    public void setUp() throws IOException {
        config = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(config);
        session = factory.openSession();
        mapper = session.getMapper(AccountDao.class);
    }

    @After
    public void tearDown() throws IOException {
        // 在关闭资源之前，提交事务
        session.commit();

        session.close();
        config.close();
    }

    @Test
    public void testFindAll() {
        List<Account> accounts = mapper.findAll();
        for (Account account : accounts) {
            System.out.println(account + "  " + account.getUser());
        }
    }
}
