package test;

import dao.UserDao;
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
 * @Date 2020/6/11 2:32
 */
public class SecondLevelCacheTest {
    private InputStream config;
    private SqlSessionFactory factory;

    @Before
    public void setUp() throws IOException {
        config = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(config);
    }

    @After
    public void tearDown() throws IOException {
        config.close();
    }

    @Test
    public void testFindOne() {
        SqlSession session1 = factory.openSession();
        UserDao mapper1 = session1.getMapper(UserDao.class);
        User user1 = mapper1.findById(41);
        System.out.println(user1);
        session1.close(); // 清空一级缓存

        SqlSession session2 = factory.openSession();
        UserDao mapper2 = session2.getMapper(UserDao.class);
        User user2 = mapper2.findById(41);
        System.out.println(user2);
        session2.close();

        System.out.println(user1 == user2);
    }
}
