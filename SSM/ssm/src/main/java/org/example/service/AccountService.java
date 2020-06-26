package org.example.service;

import org.example.domain.Account;

import java.util.List;

/**
 * 账户service接口
 *
 * @Author hustffx
 * @Date 2020/6/26 10:56
 */
public interface AccountService {
    /**
     * 查询所有账户
     *
     * @return
     */
    List<Account> findAll();

    /**
     * 保存账户
     *
     * @param account
     */
    void saveAccount(Account account);
}
