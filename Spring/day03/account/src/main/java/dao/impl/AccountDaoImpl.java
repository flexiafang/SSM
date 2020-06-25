package dao.impl;

import dao.AccountDao;
import domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.ConnectionUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * 账户的持久层实现类
 *
 * @Author hustffx
 * @Date 2020/6/15 17:45
 */
public class AccountDaoImpl implements AccountDao {
    private QueryRunner runner;
    private ConnectionUtils connectionUtils;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    @Override
    public List<Account> findAll() {
        List<Account> accounts = null;
        try {
            accounts = runner.query(connectionUtils.getThreadConnection(),
                    "select * from account", new BeanListHandler<>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public Account findById(Integer accountId) {
        Account account = null;
        try {
            account = runner.query(connectionUtils.getThreadConnection(),
                    "select * from account where id = ?",
                    new BeanHandler<>(Account.class), accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public void save(Account account) {
        try {
            runner.update(connectionUtils.getThreadConnection(),
                    "insert into account(name,money) values(?,?)",
                    account.getName(), account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Account account) {
        try {
            runner.update(connectionUtils.getThreadConnection(),
                    "update account set name = ?, money = ? where id = ?",
                    account.getName(), account.getMoney(), account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer accountId) {
        try {
            runner.update(connectionUtils.getThreadConnection(),
                    "delete from account where id = ?", accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account findByName(String accountName) {
        Account account = null;
        try {
            List<Account> accounts = runner.query(connectionUtils.getThreadConnection(),
                    "select * from account where name = ?",
                    new BeanListHandler<>(Account.class), accountName);
            if (accounts == null || accounts.size() == 0) {
                return null;
            }
            if (accounts.size() > 1) {
                throw new RuntimeException("结果集不唯一，数据有问题");
            }
            account = accounts.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }
}
