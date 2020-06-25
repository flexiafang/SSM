package dao;

import domain.User;

import java.util.List;

/**
 * 用户的持久层接口
 *
 * @Author hustffx
 * @Date 2020/6/5 17:02
 */
public interface UserDao {
    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> findAll();

    /**
     * 根据Id查询用户
     *
     * @param userId
     * @return
     */
    User findById(int userId);

    /**
     * 更新用户信息
     *
     * @param user
     */
    void updateUser(User user);
}
