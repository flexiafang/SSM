package service.impl;

import service.AccountService;

/**
 * 账户的业务层接口实现类
 *
 * @Author hustffx
 * @Date 2020/6/17 22:11
 */
public class AccountServiceImpl implements AccountService {
    @Override
    public void saveAccount() {
        System.out.println("保存了账户");
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("更新了账户" + i);
    }

    @Override
    public int findAccount() {
        System.out.println("查询了账户");
        return 0;
    }
}
