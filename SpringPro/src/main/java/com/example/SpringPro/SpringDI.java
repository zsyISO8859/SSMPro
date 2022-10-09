package com.example.SpringPro;

import com.example.dao.GetSource;
import com.example.domain.Dog;
import com.example.domain.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//spring 的依赖注入测试
public class SpringDI {
    //通过配置Dog类的构造参数 再通过xml文件的构造方法注入可以给Dog类的属性初始化值
    @Test
    public void test(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext1.xml");
        Dog dog = (Dog)ac.getBean("dog");
        System.out.println(dog.name);
        System.out.println(dog.age);
    }

    //使用spring的DI注入对象类型的属性
    //property属性使用ref="dog"来引用对象属性
    @Test
    public void test1(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext1.xml");
        User user = (User)ac.getBean("user");
        System.out.println(user);
    }

    //xml使用p命名空间就无需写这么多的property
    @Test
    public void test2(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext2.xml");
        User user = (User)ac.getBean("user");
        System.out.println(user);
    }

    //测试对象属性为：数组 list集合 set集合 map集合 的注入方式
    @Test
    public void test3(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext3.xml");
        User user = (User)ac.getBean("user");
        System.out.println(user);
    }
}
