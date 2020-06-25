package test;

import dao.UserDao;
import domain.QueryVo;
import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @Author hustffx
 * @Date 2020/6/5 17:10
 */
public class DynamicSQLTest {
    private InputStream config;
    private SqlSession session;
    private UserDao mapper;

    @Before
    public void setUp() throws Exception {
        config = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(config);
        session = factory.openSession();
        mapper = session.getMapper(UserDao.class);
    }

    @After
    public void tearDown() throws Exception {
        // 在关闭资源之前，提交事务
        session.commit();

        session.close();
        config.close();
    }

    @Test
    public void testFindByUser() {
        User user = new User();
        user.setUsername("%王%");
        user.setAddress("%金燕龙%");

        List<User> users = mapper.findByUser(user);
        for (User u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void testFindInIds() {
        QueryVo vo = new QueryVo();
        vo.setIds(List.of(41, 42, 43, 46, 57));

        List<User> users = mapper.findInIds(vo);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
