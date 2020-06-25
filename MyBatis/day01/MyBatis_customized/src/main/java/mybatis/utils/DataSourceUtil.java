package mybatis.utils;

import mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 用于创建数据源的工具类
 *
 * @Author hustffx
 * @Date 2020/6/5 11:25
 */
public class DataSourceUtil {
    /**
     * 用于获取一个连接
     *
     * @param cfg
     * @return
     */
    public static Connection getConnection(Configuration cfg) {
        Connection conn = null;
        try {
            Class.forName(cfg.getDriver());
            conn = DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
}
