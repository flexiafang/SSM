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
 * @Date 2020/6/5 17:10
 */
public class FirstLevelCacheTest {
    private InputStream config;
    private SqlSession session;
    private UserDao mapper;

    @Before
    public void setUp() throws IOException {
        config = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(config);
        session = factory.openSession();
        mapper = session.getMapper(UserDao.class);
    }

    @After
    public void tearDown() throws IOException {
        // 在关闭资源之前，提交事务
        session.commit();

        session.close();
        config.close();
    }

    @Test
    public void testFirstLevelCache() {
        User user1 = mapper.findById(41);
        // session.clearCache();
        User user2 = mapper.findById(41);
        System.out.println(user1 == user2);
    }

    @Test
    public void testClearCache() {
        User user1 = mapper.findById(57);
        System.out.println(user1);

        /*
        user1.setUsername("update user clear cache");
        user1.setAddress("北京市海淀区");
        mapper.updateUser(user1);
        */
        session.commit();

        User user2 = mapper.findById(57);
        System.out.println(user2);

        System.out.println(user1 == user2);
    }
}
