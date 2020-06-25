package service.impl;

import service.AccountService;

/**
 * 账户的业务层实现类
 *
 * @Author hustffx
 * @Date 2020/6/13 15:02
 */
public class AccountServiceImpl implements AccountService {
    public AccountServiceImpl() {
        System.out.println("AccountService对象创建完成");
    }

    @Override
    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了");
    }

    public void init() {
        System.out.println("对象初始化了");
    }

    public void destroy() {
        System.out.println("对象销毁了");
    }
}
