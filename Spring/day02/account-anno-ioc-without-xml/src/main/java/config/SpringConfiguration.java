package config;

import org.springframework.context.annotation.*;

/**
 * 该类是一个配置类，它的作用与 bean.xml 是一样的
 *
 * @Author hustffx
 * @Date 2020/6/16 0:08
 */
@Configuration
@ComponentScan(basePackages = {"service", "dao"})
@Import(JdbcConfig.class)
public class SpringConfiguration {
}
