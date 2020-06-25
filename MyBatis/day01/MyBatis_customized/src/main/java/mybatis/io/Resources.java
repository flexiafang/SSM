package mybatis.io;

import java.io.InputStream;

/**
 * 使用类加载器读取配置文件的类
 *
 * @Author hustffx
 * @Date 2020/6/4 22:45
 */
public class Resources {
    private Resources() {
    }

    /**
     * 根据传入的参数，获取一个字节输入流
     *
     * @param filePath 资源路径
     * @return 字节输入流
     */
    public static InputStream getResourceAsStream(String filePath) {
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
