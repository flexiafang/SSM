package utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 用于记录日志的工具类，提供了公共代码
 *
 * @Author hustffx
 * @Date 2020/6/17 22:13
 */
@Component("logger")
@Aspect // 表示当前类是一个切面类
public class Logger {

    @Pointcut("execution(* service.impl.*.*(..))")
    private void pt() {
    }

    /**
     * 前置通知
     */
    // @Before("pt()")
    public void beforePrintLog() {
        System.out.println("前置通知Logger类中的beforePrintLog方法开始记录日志");
    }

    /**
     * 后置通知
     */
    // @AfterReturning("pt()")
    public void afterReturningPrintLog() {
        System.out.println("后置通知Logger类中的afterReturningPrintLog方法开始记录日志");
    }

    /**
     * 异常通知
     */
    // @AfterThrowing("pt()")
    public void afterThrowingPrintLog() {
        System.out.println("异常通知Logger类中的afterThrowingPrintLog方法开始记录日志");
    }

    /**
     * 最终通知
     */
    // @After("pt()")
    public void afterPrintLog() {
        System.out.println("最终通知Logger类中的afterPrintLog方法开始记录日志");
    }

    /**
     * 环绕通知
     * 问题：
     * 当我们配置了环绕通知之后，切入点方法没有执行，而通知方法执行了。
     * 分析：
     * 通过对比动态代理中的环绕通知代码，发现动态代理的环绕通知有明确的切入点方法调用，而我们的代码中没有。
     * 解决：
     * Spring框架为我们提供了一个接口：ProceedingJoinPoint。该接口有一个方法proceed()，此方法就相当于明确调用切入点方法。
     * 该接口可以作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供该接口的实现类供我们使用。
     * spring中的环绕通知：
     * 它是spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式。
     */
    @Around("pt()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp) {
        Object rtValue = null;
        try {
            // 得到方法执行所需的参数
            Object[] args = pjp.getArgs();
            System.out.println("前置：Logger类中的aroundPrintLog方法开始记录日志");
            // 明确调用业务层方法（切入点方法）
            rtValue = pjp.proceed(args);
            System.out.println("后置：Logger类中的aroundPrintLog方法开始记录日志");
        } catch (Throwable throwable) {
            System.out.println("异常：Logger类中的aroundPrintLog方法开始记录日志");
            throwable.printStackTrace();
        } finally {
            System.out.println("最终：Logger类中的aroundPrintLog方法开始记录日志");
        }
        return rtValue;
    }
}
