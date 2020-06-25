package factory;

import service.AccountService;
import service.impl.AccountServiceImpl;

/**
 * 模拟一个静态工厂类
 *
 * @Author hustffx
 * @Date 2020/6/13 22:46
 */
public class StaticFactory {
    public static AccountService getAccountService() {
        return new AccountServiceImpl();
    }
}
