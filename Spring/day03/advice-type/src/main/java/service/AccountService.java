package service;

/**
 * 账户的业务层接口
 *
 * @Author hustffx
 * @Date 2020/6/17 21:58
 */
public interface AccountService {
    /**
     * 模拟保存账户
     */
    void saveAccount();

    /**
     * 模拟更新账户
     *
     * @param i
     */
    void updateAccount(int i);

    /**
     * 模拟查询账户
     *
     * @return
     */
    int findAccount();
}
