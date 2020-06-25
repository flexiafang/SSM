package utils;

/**
 * 用于记录日志的工具类，提供了公共代码
 *
 * @Author hustffx
 * @Date 2020/6/17 22:13
 */
public class Logger {
    /**
     * 用于打印日志，计划让其在切入点方法（即业务层方法）之前执行
     */
    public void printLog() {
        System.out.println("Logger类中的printLog方法开始记录日志了");
    }
}
