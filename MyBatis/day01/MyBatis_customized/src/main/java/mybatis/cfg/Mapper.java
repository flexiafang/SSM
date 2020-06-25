package mybatis.cfg;

/**
 * 用于封装执行SQL语句和结果类型的全限定类名
 *
 * @Author hustffx
 * @Date 2020/6/5 0:32
 */
public class Mapper {
    /**
     * SQL
     */
    private String queryString;
    /**
     * 实体类的全限定类名
     */
    private String resultType;

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
