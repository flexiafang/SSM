package dao;

import domain.Account;

import java.util.List;

/**
 * @Author hustffx
 * @Date 2020/6/9 0:05
 */
public interface AccountDao {
    /**
     * 查询所有账户，同时包含用户姓名和地址信息
     *
     * @return
     */
    List<Account> findAll();

    /**
     * 根据用户id查询账户信息
     *
     * @return
     */
    List<Account> findByUid();
}
