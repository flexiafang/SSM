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
public class MyBatisCRUDTest {
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
        mapper.deleteUser(55);
    }

    @Test
    public void testFindOne() {
        User user = mapper.findById(41);
        System.out.println(user);
    }

    @Test
    public void testFindByName() {
        // List<User> users = mapper.findByName("%王%");
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

    @Test
    public void testFindByVo() {
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        vo.setUser(user);

        List<User> users = mapper.findByVo(vo);
        for (User u : users) {
            System.out.println(u);
        }
    }
}
