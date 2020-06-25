package jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JdbcTemplate最基本的用法
 *
 * @Author hustffx
 * @Date 2020/6/18 13:57
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        // spring的内置数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/springdb");
        ds.setUsername("root");
        ds.setPassword("root");

        JdbcTemplate jt = new JdbcTemplate(ds);
        jt.execute("insert into account(name,money) values('ddd',1000)");
    }
}
