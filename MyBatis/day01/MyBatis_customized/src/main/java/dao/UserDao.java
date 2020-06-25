package dao;

import domain.User;
import mybatis.annotations.Select;

import java.util.List;

/**
 * 用户的持久层接口
 *
 * @Author hustffx
 * @Date 2020/6/3 19:19
 */
public interface UserDao {
    /**
     * 查询所有用户
     *
     * @return
     */
    @Select("select * from user")
    List<User> findAll();
}
