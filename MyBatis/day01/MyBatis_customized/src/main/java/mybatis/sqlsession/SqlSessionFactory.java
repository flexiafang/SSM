package mybatis.sqlsession;

/**
 * @Author hustffx
 * @Date 2020/6/4 22:52
 */
public interface SqlSessionFactory {
    /**
     * 用于打开一个新的SqlSession对象
     *
     * @return
     */
    SqlSession openSession();
}
