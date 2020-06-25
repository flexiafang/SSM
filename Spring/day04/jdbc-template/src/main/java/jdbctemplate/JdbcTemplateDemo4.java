package jdbctemplate;

import dao.AccountDao;
import domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTemplate最基本的用法
 *
 * @Author hustffx
 * @Date 2020/6/18 13:57
 */
public class JdbcTemplateDemo4 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountDao ad = ac.getBean("accountDao", AccountDao.class);
        Account account = ad.findById(1);
        System.out.println(account);

        account.setMoney(10000f);
        ad.update(account);
    }
}
