package com.example.SpringPro2;

import com.example.service.GoodsService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * spring xml和注解配合开发
 */
public class SpringIntegration {

    @Test
    public void test(){
        ClassPathXmlApplicationContext ca = new ClassPathXmlApplicationContext("applicationContextPro2.xml");
        GoodsService bean = (GoodsService)ca.getBean("goodsService");
        ClassLoader classLoader = bean.getClass().getClassLoader();
        GoodsService goodsService = (GoodsService)Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("asd");
                return method.invoke(bean, args);
            }
        });
        goodsService.goodsService();
    }
}
