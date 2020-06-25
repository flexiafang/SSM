package dao;

import domain.Account;

/**
 * 账户的持久层接口
 *
 * @Author hustffx
 * @Date 2020/6/18 16:59
 */
public interface AccountDao {
    /**
     * 根据id查询账户
     *
     * @param accountId
     * @return
     */
    Account findById(Integer accountId);

    /**
     * 根据名称查询账户
     *
     * @param accountName
     * @return
     */
    Account findByName(String accountName);

    /**
     * 更新账户
     *
     * @param account
     */
    void update(Account account);
}
