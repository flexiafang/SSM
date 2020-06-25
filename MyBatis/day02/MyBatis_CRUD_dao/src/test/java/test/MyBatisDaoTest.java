package test;

import dao.UserDao;
import dao.impl.UserDaoImpl;
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
 * @Date 2020/6/5 17:10
 */
public class MyBatisDaoTest {
    private InputStream config;
    private UserDao mapper;

    @Before
    public void setUp() throws IOException {
        config = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(config);
        mapper = new UserDaoImpl(factory);
    }

    @After
    public void tearDown() throws IOException {
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
        user.setUsername("mybatis save user last insert id");
        user.setAddress("湖北省武汉市");
        user.setSex("男");
        user.setBirthday(new Date());

        System.out.println("保存操作之前：" + user);
        mapper.saveUser(user);
        System.out.println("保存操作之后：" + user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(55);
        user.setUsername("mybatis update user");
        user.setAddress("北京市海淀区");
        user.setSex("女");
        user.setBirthday(new Date());

        mapper.updateUser(user);
    }

    @Test
    public void testDelete() {
        mapper.deleteUser(63);
    }

    @Test
    public void testFindOne() {
        User user = mapper.findById(41);
        System.out.println(user);
    }

    @Test
    public void testFindByName() {
        List<User> users = mapper.findByName("王");
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
