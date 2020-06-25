package service;

import domain.Account;

/**
 * 账户的业务层接口
 *
 * @Author hustffx
 * @Date 2020/6/18 23:36
 */
public interface AccountService {
    /**
     * 根据id查询账户信息
     *
     * @param accountId
     * @return
     */
    Account findById(Integer accountId);

    /**
     * 转账
     *
     * @param sourceName
     * @param targetName
     * @param money
     */
    void transfer(String sourceName, String targetName, Float money);
}
