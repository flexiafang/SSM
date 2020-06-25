package factory;

import domain.Account;
import service.AccountService;
import utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建 Service 代理对象的工厂
 *
 * @Author hustffx
 * @Date 2020/6/17 18:41
 */
public class BeanFactory {
    private AccountService accountService;
    private TransactionManager transactionManager;

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public final void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    /**
     * 获取 Service 的代理对象
     *
     * @return
     */
    public AccountService getAccountService() {
        return (AccountService) Proxy.newProxyInstance(
                accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 添加事务支持
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) {
                        Object rtValue = null;
                        try {
                            transactionManager.beginTransaction();
                            rtValue = method.invoke(accountService, args);
                            transactionManager.commit();
                        } catch (Exception e) {
                            transactionManager.rollback();
                            e.printStackTrace();
                        } finally {
                            transactionManager.release();
                        }
                        return rtValue;
                    }
                });
    }
}
