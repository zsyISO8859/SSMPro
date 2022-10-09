package com.proxy.controller;

import com.proxy.service.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
//主要用于接口的动态代理  普通的类无法使用这种JDK的动态代理
public class ProxyFactory {
    public static UserService createProxy(UserService userDao) {
        //返回一个动态代理类  调用此动态代理类一定会经过invoke方法  相当于接口方法的回调函数。
        return (UserService) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if ("insert".equals(method.getName())) {
                    System.out.println("权限验证.....");
                    Object invoke = method.invoke(userDao, args);
                    System.out.println("日志记录.....");
                    return invoke;
                }
                return method.invoke(userDao, args);
            }
        });
    }
}
