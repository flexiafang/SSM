package dao.impl;

import dao.AccountDao;

/**
 * 账户的持久层实现类
 *
 * @Author hustffx
 * @Date 2020/6/13 15:05
 */
public class AccountDaoImpl implements AccountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存了账户");
    }
}
