package com.proxy.controller;

import com.proxy.domain.Goods;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

//主要用于普通类的动态代理
//实现方式：通过类自动生成一个子类，将子类传作为动态代理对象，用动态代理对象调用方法，就会找到该子类的父类进行调用方法。
public class ProxyCglibFactory implements MethodInterceptor {

    public Goods getCglibDomain(Goods goods) {

        //创建cglib核心类
        Enhancer enhancer = new Enhancer();
        //设置cglib的父类 用于生成一个子类
        enhancer.setSuperclass(goods.getClass());
        //设置回调
        enhancer.setCallback(this);
        //创建代理类
        Goods goodsProxy = (Goods) enhancer.create();
        return goodsProxy;

    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if ("save".equals(method.getName())){
            System.out.println("权限验证。。。。。");
            Object o1 = methodProxy.invokeSuper(o, objects);
            System.out.println("记录日志");
            return o1;
        }
        return methodProxy.invokeSuper(o, objects);
    }
}
