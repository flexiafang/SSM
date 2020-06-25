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
 * @Author hustffx
 * @Date 2020/6/13 15:07
 */
public class Client {
    /**
     * 获取spring的IoC容器，并根据id获取对象
     */
    public static void main(String[] args) {
        testApplicationContext();
        testBeanFactory();
    }

    private static void testApplicationContext() {
        // 获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 根据id获取bean对象
        AccountService as = (AccountService) ac.getBean("accountService");
        AccountDao ad = ac.getBean("accountDao", AccountDao.class);

        System.out.println(as);
        System.out.println(ad);
    }

    private static void testBeanFactory() {
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        AccountService as = factory.getBean("accountService", AccountService.class);
        System.out.println(as);
    }
}
