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

/**
 * @Author hustffx
 * @Date 2020/6/5 17:10
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
    public void testSecondLevelCache() {
        SqlSession sqlSession1 = factory.openSession();
        UserDao mapper1 = sqlSession1.getMapper(UserDao.class);
        User user1 = mapper1.findById(41);
        System.out.println(user1);
        sqlSession1.close(); // 一级缓存消失

        SqlSession sqlSession2 = factory.openSession();
        UserDao mapper2 = sqlSession2.getMapper(UserDao.class);
        User user2 = mapper2.findById(41);
        System.out.println(user2);
        sqlSession2.close();

        System.out.println(user1 == user2);
    }
}
