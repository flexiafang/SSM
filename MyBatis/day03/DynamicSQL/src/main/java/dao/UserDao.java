package dao;

import domain.QueryVo;
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
     * 根据用户信息查询用户列表
     *
     * @param user
     * @return
     */
    List<User> findByUser(User user);

    /**
     * 根据id集合查询用户
     *
     * @param vo
     * @return
     */
    List<User> findInIds(QueryVo vo);
}
