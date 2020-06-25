package mybatis.cfg;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义MyBatis的配置类
 *
 * @Author hustffx
 * @Date 2020/6/5 0:27
 */
public class Configuration {
    private String driver;
    private String url;
    private String username;
    private String password;

    private final Map<String, Mapper> mappers = new HashMap<>();

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    public void setMappers(Map<String, Mapper> mappers) {
        // 此处需要使用追加的方式
        this.mappers.putAll(mappers);
    }
}
