package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author hustffx
 * @Date 2020/6/18 11:49
 */
@Configuration
@ComponentScan(basePackages = {"service", "utils"})
@EnableAspectJAutoProxy
public class SpringConfiguration {
}
