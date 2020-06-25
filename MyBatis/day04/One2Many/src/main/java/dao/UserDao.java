package dao;

import domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * 在MyBatis中针对CRUD有四个注解 @Select @Insert @Delete @Update
 *
 * @Author hustffx
 * @Date 2020/6/11 0:05
 */
@CacheNamespace(blocking = true)
public interface UserDao {
    /**
     * 查询所有用户
     *
     * @return
     */
    @Select("select * from user")
    @Results(id = "userMap",
            value = {
                    @Result(id = true, column = "id", property = "userId"),
                    @Result(column = "username", property = "userName"),
                    @Result(column = "sex", property = "userSex"),
                    @Result(column = "address", property = "userAddress"),
                    @Result(column = "birthday", property = "userBirthday"),
                    @Result(column = "id", property = "accounts",
                            many = @Many(select = "dao.AccountDao.findByUid", fetchType = FetchType.LAZY))
            })
    List<User> findAll();

    /**
     * 根据Id查询用户
     *
     * @param userId
     * @return
     */
    @Select("select * from user where id = #{uid}")
    @ResultMap(value = {"userMap"})
    User findById(int userId);
}
