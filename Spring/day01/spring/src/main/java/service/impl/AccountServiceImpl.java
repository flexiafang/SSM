package service.impl;

import dao.AccountDao;
import dao.impl.AccountDaoImpl;
import service.AccountService;

/**
 * 账户的业务层实现类
 *
 * @Author hustffx
 * @Date 2020/6/13 15:02
 */
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public AccountServiceImpl() {
        // 此处的依赖关系有待解决
        accountDao = new AccountDaoImpl();
        // 用于Debug验证BeanFactory和ApplicationContext创建对象的时机
        System.out.println("AccountService对象创建完成");
    }

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
