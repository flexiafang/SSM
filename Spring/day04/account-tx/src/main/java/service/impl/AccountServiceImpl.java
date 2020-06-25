package service.impl;

import dao.AccountDao;
import domain.Account;
import service.AccountService;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 账户的业务层实现类
 * 事务控制应该都是在业务层
 *
 * @author hustffx
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    private TransactionTemplate transactionTemplate;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return transactionTemplate.execute(status -> accountDao.findAccountById(accountId));
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        transactionTemplate.execute(status -> {
            System.out.println("transfer....");
            // 根据名称查询转出账户
            Account source = accountDao.findAccountByName(sourceName);
            // 根据名称查询转入账户
            Account target = accountDao.findAccountByName(targetName);
            // 转出账户减钱
            source.setMoney(source.getMoney() - money);
            // 转入账户加钱
            target.setMoney(target.getMoney() + money);
            // 更新转出账户
            accountDao.updateAccount(source);

            int i = 1 / 0;

            // 更新转入账户
            accountDao.updateAccount(target);
            return null;
        });
    }
}
