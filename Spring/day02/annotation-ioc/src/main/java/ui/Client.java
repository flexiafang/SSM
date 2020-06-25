package ui;

import dao.AccountDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import service.AccountService;

/**
 * 模拟一个表现层，用于调用业务层
 *
 * @Author hustffx
 * @Date 2020/6/13 15:07
 */
public class Client {
    public static void main(String[] args) {
        // 获取核心容器对象
        // ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 根据id获取bean对象
        /*AccountService as = (AccountService) ac.getBean("accountService");
        System.out.println(as);

        AccountDao ad = ac.getBean("accountDaoImpl", AccountDao.class);
        System.out.println(ad);

        as.saveAccount();*/

        /*AccountService as1 = (AccountService) ac.getBean("accountService");
        AccountService as2 = (AccountService) ac.getBean("accountService");
        System.out.println(as1 == as2);*/

        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService as = (AccountService) ac.getBean("accountService");
        ac.close();
    }
}
