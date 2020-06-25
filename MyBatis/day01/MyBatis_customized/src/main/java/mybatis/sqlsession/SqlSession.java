package mybatis.sqlsession;

/**
 * MyBatis中与数据库交互的核心类
 * 它里面可以创建dao接口的代理对象
 *
 * @Author hustffx
 * @Date 2020/6/4 22:54
 */
public interface SqlSession {
    /**
     * 根据参数创建一个代理对象
     *
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    /**
     * 释放资源
     */
    void close();
}
