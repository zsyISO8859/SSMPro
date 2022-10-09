package com.aop3_anno.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyAspect1 {

    @Before(value = "MyAspect1.pointcut1()")
    public void before() {
        System.out.println("before切面1");
    }

    @Around(value = "MyAspect1.pointcut2() || MyAspect1.pointcut1()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("前置1");
        Object proceed = joinPoint.proceed();
        System.out.println("后置1");
        return proceed;
    }

    @AfterReturning(value = "MyAspect1.pointcut3()", returning = "turn")
    public void afterreturning(Object turn) {
        System.out.println("afterreturning" + turn);
    }

    @AfterThrowing(value = "MyAspect1.pointcut4()", throwing = "ex")
    public void afterthrowing(Throwable ex) {
        System.out.println("afterthrowing" + ex);
    }

    @After(value = "MyAspect1.pointcut5() || MyAspect1.pointcut1()")
    public void after() {
        System.out.println("最终事件....");
    }


    @Pointcut("execution(* com.aop3_anno.domain.User.save(..))")
    public void pointcut1() {}

    @Pointcut("execution(* com.aop3_anno.domain.User.update(..))")
    public void pointcut2() {}

    @Pointcut("execution(* com.aop3_anno.domain.User.delete(..))")
    public void pointcut3() {}

    @Pointcut("execution(* com.aop3_anno.domain.User.find(..))")
    public void pointcut4() {}

    @Pointcut("execution(* com.aop3_anno.domain.User.finish(..))")
    public void pointcut5() {}


}
