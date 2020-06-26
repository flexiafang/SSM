package org.example.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.dao.AccountDao;
import org.example.domain.Account;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author hustffx
 * @Date 2020/6/26 23:06
 */
public class MyBatisTest {
    @Test
    public void testFindAll() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        AccountDao accountDao = session.getMapper(AccountDao.class);
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
        session.close();
        in.close();
    }

    @Test
    public void testSave() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        AccountDao accountDao = session.getMapper(AccountDao.class);
        Account account = new Account();
        account.setName("hustffx");
        account.setMoney(400.0);
        accountDao.saveAccount(account);
        session.commit();
        session.close();
        in.close();
    }
}
