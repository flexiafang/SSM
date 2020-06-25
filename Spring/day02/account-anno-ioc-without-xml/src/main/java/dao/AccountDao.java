package dao;

import domain.Account;

import java.util.List;

/**
 * 账户的持久层接口
 *
 * @Author hustffx
 * @Date 2020/6/15 17:42
 */
public interface AccountDao {
    /**
     * 查询所有
     *
     * @return
     */
    List<Account> findAll();

    /**
     * 查询一个
     *
     * @param accountId
     * @return
     */
    Account findById(Integer accountId);

    /**
     * 保存
     *
     * @param account
     */
    void save(Account account);

    /**
     * 更新
     *
     * @param account
     */
    void update(Account account);

    /**
     * 删除
     *
     * @param accountId
     */
    void delete(Integer accountId);
}
