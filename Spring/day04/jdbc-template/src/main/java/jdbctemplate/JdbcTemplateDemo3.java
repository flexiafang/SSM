package jdbctemplate;

import domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * JdbcTemplate的CRUD操作
 *
 * @Author hustffx
 * @Date 2020/6/18 13:57
 */
public class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);

        // jt.update("insert into account(name,money) values(?,?)", "fff", 2000f);
        // jt.update("update account set name = ?, money = ? where id = ?", "test", 3000, 4);
        // jt.update("delete from account where id = ?", 5);

        // List<Account> accounts = jt.query("select * from account where money > ?", new AccountRowMapper(), 1000f);
        /*List<Account> accounts = jt.query("select * from account where money > ?",
                new BeanPropertyRowMapper<>(Account.class), 1000f);
        for (Account account : accounts) {
            System.out.println(account);
        }*/

        /*List<Account> accounts = jt.query("select * from account where id = ?",
                new BeanPropertyRowMapper<>(Account.class), 1);
        System.out.println(accounts);*/

        Long count = jt.queryForObject("select count(*) from account where money > ?", Long.class, 1000f);
        System.out.println(count);
    }
}

/**
 * 定义Account的封装策略
 */
class AccountRowMapper implements RowMapper<Account> {
    /**
     * 把结果集的数据封装到Account中，然后由spring把每个Account加到集合中
     *
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getFloat("money"));
        return account;
    }
}
