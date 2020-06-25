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
     * 保存用户
     *
     * @param user
     * @return
     */
    int saveUser(User user);

    /**
     * 更新用户
     *
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据Id删除用户
     *
     * @param userId
     */
    void deleteUser(int userId);

    /**
     * 根据Id查询用户
     *
     * @param userId
     * @return
     */
    User findById(int userId);

    /**
     * 根据名称模糊查询用户信息
     *
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 查询总用户数
     *
     * @return
     */
    int findTotal();
}
