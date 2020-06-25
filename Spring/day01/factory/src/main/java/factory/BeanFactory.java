package factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 创建bean对象的工厂。
 * Bean：在计算机英语中，有可重用组件的含义。
 * JavaBean：用java语言编写的可重用组件。 javabean > 实体类
 * 它就是创建我们的service和dao对象的。
 * 第一个：需要一个配置文件来配置我们的service和dao
 * 配置的内容：唯一标识=全限定类名（key=value)
 * 第二个：通过读取配置文件中配置的内容，反射创建对象
 * 我的配置文件可以是xml也可以是properties
 *
 * @Author hustffx
 * @Date 2020/6/13 15:10
 */
public class BeanFactory {
    /**
     * 定义一个Properties对象
     */
    private static Properties props;

    /**
     * 定义一个Map容器，用于存放已经创建的对象
     */
    private static Map<String, Object> beans;

    // 使用静态代码块为Properties对象赋值
    static {
        try {
            // 读取配置文件
            props = new Properties();
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            // 实例化容器
            beans = new HashMap<>();
            // 取出配置文件中所有的key
            Enumeration<Object> keys = props.keys();
            while (keys.hasMoreElements()) {
                // 取出每个key
                String key = keys.nextElement().toString();
                // 根据key获取value
                String beanPath = props.getProperty(key);
                Object value = Class.forName(beanPath).getDeclaredConstructor().newInstance();
                beans.put(key, value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败");
        }
    }

    /**
     * 根据Bean的名称获取bean对象
     *
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {
        return beans.get(beanName);
    }
}
