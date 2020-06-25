package service.impl;

import dao.AccountDao;
import domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import service.AccountService;

/**
 * 账户的业务层实现
 *
 * @Author hustffx
 * @Date 2020/6/15 17:40
 */
@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public Account findById(Integer accountId) {
        return accountDao.findById(accountId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("Transferring...");
        // 根据名称查询转出账户
        Account source = accountDao.findByName(sourceName);
        // 根据名称查询转入账户
        Account target = accountDao.findByName(targetName);
        // 转出账户减钱
        source.setMoney(source.getMoney() - money);
        // 转入账户加钱
        target.setMoney(target.getMoney() + money);
        // 更新转出账户
        accountDao.update(source);

        // 模拟转账异常
        // int i = 1 / 0;

        // 更新转入账户
        accountDao.update(target);
    }
}
