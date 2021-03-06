package service;

import domain.Account;

import java.util.List;

/**
 * 账户的业务层
 *
 * @Author hustffx
 * @Date 2020/6/15 17:29
 */
public interface AccountService {
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
