package dao;

import domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 在MyBatis中针对CRUD有四个注解 @Select @Insert @Delete @Update
 *
 * @Author hustffx
 * @Date 2020/6/11 0:05
 */
public interface UserDao {
    /**
     * 查询所有用户
     *
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 保存用户
     *
     * @param user
     * @return
     */
    @Insert("insert into user values(null,#{username},#{birthday},#{sex},#{address})")
    @SelectKey(keyColumn = "id", keyProperty = "id", resultType = Integer.class,
            before = false, statement = {"select last_insert_id()"})
    int saveUser(User user);

    /**
     * 更新用户
     *
     * @param user
     */
    @Update("update user set username=#{username},address=#{address},sex=#{sex},birthday=#{birthday} where id=#{id}")
    void updateUser(User user);

    /**
     * 根据Id删除用户
     *
     * @param userId
     */
    @Delete("delete from user where id = #{uid}")
    void deleteUser(int userId);

    /**
     * 根据Id查询用户
     *
     * @param userId
     * @return
     */
    @Select("select * from user where id = #{uid}")
    User findById(int userId);

    /**
     * 根据名称模糊查询用户信息
     *
     * @param username
     * @return
     */
    @Select("select * from user where username like #{name}")
    List<User> findByName(String username);

    /**
     * 查询总用户数
     *
     * @return
     */
    @Select("select count(*) from user")
    int findTotal();
}
