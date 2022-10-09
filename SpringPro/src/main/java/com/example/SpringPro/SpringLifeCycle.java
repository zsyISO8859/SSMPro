package com.example.SpringPro;

import com.example.domain.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLifeCycle {
    //加载xml的时候就会调用init-method方法
    //调用close()方法就会调用destroy-method方法
    @Test
    public void test(){
        ClassPathXmlApplicationContext ca = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User)ca.getBean("user");
        ca.close();
    }

    //默认javabean是单例（每次获取到的javabean是同一个 地址是一样的）
    @Test
    public void test1(){
        ClassPathXmlApplicationContext ca = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User)ca.getBean("user");
        User user1 = (User)ca.getBean("user");
        System.out.println(user);
        System.out.println(user1);
    }

    //测试多例模式，每次获取对象的地址不一样
    //多例模式对象会被gc回收 无需自己手动回收
    @Test
    public void test2(){
        ClassPathXmlApplicationContext ca = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User)ca.getBean("user1");
        User user1 = (User)ca.getBean("user1");
        System.out.println(user);
        System.out.println(user1);
    }

    //测试 静态工厂实例化
    @Test
    public void test3(){
        ClassPathXmlApplicationContext ca = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User)ca.getBean("user3");
        System.out.println(user);
    }
}
