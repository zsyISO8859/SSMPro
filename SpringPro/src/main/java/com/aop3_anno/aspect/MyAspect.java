package com.aop3_anno.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyAspect {

    @Before(value = "execution(* com.aop3_anno.domain.User.save(..))")
    public void before(){
        System.out.println("before切面");
    }

    @Around(value = "execution(* com.aop3_anno.domain.User.update(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("前置");
        Object proceed = joinPoint.proceed();
        System.out.println("后置");
        return proceed;
    }

    @AfterReturning(value = "execution(* com.aop3_anno.domain.User.delete(..))",returning = "turn")
    public void afterreturning(Object turn){
        System.out.println("afterreturning"+turn);
    }

    @AfterThrowing(value = "execution(* com.aop3_anno.domain.User.find(..))",throwing = "ex")
    public void afterthrowing(Throwable ex){
        System.out.println("afterthrowing"+ex);
    }

    @After(value = "execution(* com.aop3_anno.domain.User.finish(..))")
    public void after(){
        System.out.println("after....");
    }
}
