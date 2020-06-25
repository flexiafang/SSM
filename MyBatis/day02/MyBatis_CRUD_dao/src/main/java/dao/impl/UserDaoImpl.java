package dao.impl;

import dao.UserDao;
import domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @Author hustffx
 * @Date 2020/6/7 17:07
 */
public class UserDaoImpl implements UserDao {
    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<User> findAll() {
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("dao.UserDao.findAll");
        session.close();
        return users;
    }

    @Override
    public int saveUser(User user) {
        SqlSession session = factory.openSession();
        int id = session.insert("dao.UserDao.saveUser", user);
        session.commit();
        session.close();
        return id;
    }

    @Override
    public void updateUser(User user) {
        SqlSession session = factory.openSession();
        session.update("dao.UserDao.updateUser", user);
        session.commit();
        session.close();
    }

    @Override
    public void deleteUser(int userId) {
        SqlSession session = factory.openSession();
        session.delete("dao.UserDao.deleteUser", userId);
        session.commit();
        session.close();
    }

    @Override
    public User findById(int userId) {
        SqlSession session = factory.openSession();
        User user = session.selectOne("dao.UserDao.findById", userId);
        session.close();
        return user;
    }

    @Override
    public List<User> findByName(String username) {
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("dao.UserDao.findByName", username);
        session.close();
        return users;
    }

    @Override
    public int findTotal() {
        SqlSession session = factory.openSession();
        int count = session.selectOne("dao.UserDao.findTotal");
        session.close();
        return count;
    }
}
