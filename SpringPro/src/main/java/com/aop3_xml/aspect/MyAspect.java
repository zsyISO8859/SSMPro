package com.aop3_xml.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
    public void checkAuth(){
        System.out.println("checkAuth");
    }

    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("前置业务");
        Object proceed = joinPoint.proceed();
        System.out.println("后置业务");
        return proceed;
    }

    public void afterreturning(Object ex){
        System.out.println("afterreturning "+ex);
    }

    public void exception(Throwable ex){
        System.out.println("exception:"+ex);
    }

    public void finial(){
        System.out.println("finial...");
    }
}
