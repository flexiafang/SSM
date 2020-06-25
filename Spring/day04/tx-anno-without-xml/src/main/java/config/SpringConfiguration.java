package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * spring的配置类，相当于bean.xml
 *
 * @Author hustffx
 * @Date 2020/6/19 1:22
 */
@ComponentScan(basePackages = {"service", "dao"})
@Import({JdbcConfig.class, TransactionConfig.class})
@EnableTransactionManagement
public class SpringConfiguration {
}
