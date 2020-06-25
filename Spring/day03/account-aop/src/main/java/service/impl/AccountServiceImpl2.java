package service.impl;

import dao.AccountDao;
import domain.Account;
import service.AccountService;
import utils.TransactionManager;

import java.util.List;

/**
 * 账户的业务层实现
 *
 * @Author hustffx
 * @Date 2020/6/15 17:40
 */
public class AccountServiceImpl2 implements AccountService {
    private AccountDao accountDao;

    private TransactionManager transactionManager;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Override
    public List<Account> findAll() {
        List<Account> accounts = null;
        try {
            transactionManager.beginTransaction();
            accounts = accountDao.findAll();
            transactionManager.commit();
        } catch (Exception e) {
            transactionManager.rollback();
        } finally {
            transactionManager.release();
        }
        return accounts;
    }

    @Override
    public Account findById(Integer accountId) {
        Account account = null;
        try {
            transactionManager.beginTransaction();
            account = accountDao.findById(accountId);
            transactionManager.commit();

        } catch (Exception e) {
            transactionManager.rollback();
        } finally {
            transactionManager.release();
        }
        return account;
    }

    @Override
    public void save(Account account) {
        try {
            transactionManager.beginTransaction();
            accountDao.save(account);
            transactionManager.commit();
        } catch (Exception e) {
            transactionManager.rollback();
        } finally {
            transactionManager.release();
        }
    }

    @Override
    public void update(Account account) {
        try {
            transactionManager.beginTransaction();
            accountDao.update(account);
            transactionManager.commit();
        } catch (Exception e) {
            transactionManager.rollback();
        } finally {
            transactionManager.release();
        }
    }

    @Override
    public void delete(Integer accountId) {
        try {
            transactionManager.beginTransaction();
            accountDao.delete(accountId);
            transactionManager.commit();
        } catch (Exception e) {
            transactionManager.rollback();
        } finally {
            transactionManager.release();
        }
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        try {
            // 开启事务
            transactionManager.beginTransaction();

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
            int i = 1 / 0;

            // 更新转入账户
            accountDao.update(target);
            // 提交事务
            transactionManager.commit();
        } catch (Exception e) {
            // 回滚事务
            transactionManager.rollback();
            e.printStackTrace();
        } finally {
            // 释放连接
            transactionManager.release();
        }
    }
}
