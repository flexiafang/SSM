package test;

import dao.RoleDao;
import dao.UserDao;
import domain.Role;
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
public class RoleTest {
    private InputStream config;
    private SqlSession session;
    private RoleDao mapper;

    @Before
    public void setUp() throws IOException {
        config = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(config);
        session = factory.openSession();
        mapper = session.getMapper(RoleDao.class);
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
        List<Role> roles = mapper.findAll();
        for (Role role : roles) {
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }
}
