package dao;

import domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Author hustffx
 * @Date 2020/6/11 1:26
 */
public interface AccountDao {
    /**
     * 查询所有账户
     *
     * @return
     */
    @Select("select * from account")
    @Results(id = "accountMap",
            value = {
                    @Result(id = true, column = "id", property = "id"),
                    @Result(column = "uid", property = "uid"),
                    @Result(column = "money", property = "money"),
                    @Result(column = "uid", property = "user",
                            one = @One(select = "dao.UserDao.findById", fetchType = FetchType.LAZY))
            })
    List<Account> findAll();

    /**
     * 根据用户Id查询账户
     *
     * @param userId
     * @return
     */
    @Select("select * from account where uid = #{uid}")
    List<Account> findByUid(int userId);
}
