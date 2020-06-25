package service.impl;

import dao.AccountDao;
import factory.BeanFactory;
import service.AccountService;

/**
 * 账户的业务层实现类
 *
 * @Author hustffx
 * @Date 2020/6/13 15:02
 */
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    private int i;

    @Override
    public void saveAccount() {
        if (accountDao == null) {
            accountDao = (AccountDao) BeanFactory.getBean("accountDao");
        }
        accountDao.saveAccount();
        System.out.println(++i);
    }
}
