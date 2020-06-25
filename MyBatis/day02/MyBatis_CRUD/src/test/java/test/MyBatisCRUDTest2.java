package test;

import dao.User2Dao;
import domain.User2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @Author hustffx
 * @Date 2020/6/5 17:10
 */
public class MyBatisCRUDTest2 {
    private InputStream config;
    private SqlSession session;
    private User2Dao mapper;

    @Before
    public void setUp() throws Exception {
        config = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(config);
        session = factory.openSession();
        mapper = session.getMapper(User2Dao.class);
    }

    @After
    public void tearDown() throws Exception {
        // 在关闭资源之前，提交事务
        session.commit();

        session.close();
        config.close();
    }

    @Test
    public void testFindAll() {
        List<User2> users = mapper.findAll();
        for (User2 user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindById() {
        User2 user = mapper.findById(41);
        System.out.println(user);
    }
}
