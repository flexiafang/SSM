package factory;

import service.AccountService;
import service.impl.AccountServiceImpl;

/**
 * 模拟一个工厂类（该类可能是jar包中的，我们无法通过修改源码的方式提供默认构造函数
 *
 * @Author hustffx
 * @Date 2020/6/13 22:46
 */
public class InstanceFactory {
    public AccountService getAccountService() {
        return new AccountServiceImpl();
    }
}
