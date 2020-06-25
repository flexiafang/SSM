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
import java.util.Date;
import java.util.List;

/**
 * @Author hustffx
 * @Date 2020/6/11 0:31
 */
public class AnnotationCRUDTest {
    private InputStream config;
    private SqlSession session;
    private UserDao mapper;

    @Before
    public void setUp() throws IOException {
        config = Resources.getResourceAsStream("SqlMapConfig.xml");
        session = new SqlSessionFactoryBuilder().build(config).openSession();
        mapper = session.getMapper(UserDao.class);
    }

    @After
    public void tearDown() throws IOException {
        session.commit();
        session.close();
        config.close();
    }

    @Test
    public void testFindAll() {
        List<User> users = mapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUserName("mybatis annotation");
        user.setUserSex("男");
        user.setUserAddress("北京市顺义区");
        user.setUserBirthday(new Date());
        mapper.saveUser(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setUserId(64);
        user.setUserName("mybatis annotation");
        user.setUserAddress("北京市海淀区");
        user.setUserSex("女");
        user.setUserBirthday(new Date());
        mapper.updateUser(user);
    }

    @Test
    public void testDelete() {
        mapper.deleteUser(62);
    }

    @Test
    public void testFindOne() {
        User user = mapper.findById(41);
        System.out.println(user);
    }

    @Test
    public void testFindByName() {
        List<User> users = mapper.findByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal() {
        int count = mapper.findTotal();
        System.out.println(count);
    }
}
