package com.proxy.controller;

import com.proxy.service.UserService;
import com.proxy.service.impl.UserServiceImpl;
import org.junit.Test;

public class ProxyTest {
    @Test
    public void proxyTest(){
        UserServiceImpl userService = new UserServiceImpl();
        UserService proxy = ProxyFactory.createProxy(userService);
        //使用动态代理的对象访问接口方法会进入回调函数invoke
        proxy.insert();
        proxy.delete();
    }
}
