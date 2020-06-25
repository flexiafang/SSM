package test;

import config.SpringConfiguration;
import domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.AccountService;

import java.util.List;

/**
 * 测试 QueryRunner 是否单例
 *
 * @Author hustffx
 * @Date 2020/6/15 19:03
 */
public class QueryRunnerTest {
    @Test
    public void testQueryRunner() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        QueryRunner runner1 = ac.getBean("runner", QueryRunner.class);
        QueryRunner runner2 = ac.getBean("runner", QueryRunner.class);
        System.out.println(runner1 == runner2);
    }
}
