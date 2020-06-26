package org.example.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.example.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 账户dao接口
 *
 * @Author hustffx
 * @Date 2020/6/26 10:54
 */
@Repository
public interface AccountDao {
    /**
     * 查询所有账户
     *
     * @return
     */
    @Select("select * from account")
    List<Account> findAll();

    /**
     * 保存账户
     *
     * @param account
     */
    @Insert("insert into account(name,money) values(#{name},#{money})")
    void saveAccount(Account account);
}
