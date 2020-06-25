package utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 连接的工具类，用于从数据源中获取一个连接，并且实现与线程的绑定
 *
 * @Author hustffx
 * @Date 2020/6/17 1:26
 */
public class ConnectionUtils {
    private final ThreadLocal<Connection> tl = new ThreadLocal<>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程上的连接
     *
     * @return 返回与当前线程绑定的连接
     */
    public Connection getThreadConnection() {
        Connection conn = tl.get();
        if (conn == null) {
            try {
                conn = dataSource.getConnection();
                tl.set(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    /**
     * 连接释放后，从线程中移除已关闭的连接
     */
    public void removeConnection() {
        tl.remove();
    }
}
