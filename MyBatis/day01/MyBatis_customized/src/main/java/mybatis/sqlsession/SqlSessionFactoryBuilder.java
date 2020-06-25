package mybatis.sqlsession;

import mybatis.cfg.Configuration;
import mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * 用于创建一个SqlSessionFactory对象
 *
 * @Author hustffx
 * @Date 2020/6/4 22:50
 */
public class SqlSessionFactoryBuilder {
    /**
     * 根据字节输入流来构建一个SqlSessionFactory工厂
     *
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config) {
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(cfg);
    }
}
