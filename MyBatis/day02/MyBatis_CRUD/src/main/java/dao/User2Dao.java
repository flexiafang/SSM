package dao;

import domain.User2;

import java.util.List;

/**
 * 用户的持久层接口
 *
 * @Author hustffx
 * @Date 2020/6/5 17:02
 */
public interface User2Dao {
    /**
     * 查询所有用户
     *
     * @return
     */
    List<User2> findAll();

    /**
     * 根据id查询用户
     *
     * @param userId
     * @return
     */
    User2 findById(int userId);
}
