package com.example.SpringPro;

import com.example.dao.GetSource;
import com.example.dao.impl.GetMysqlSourceImpl;
import com.example.factory.FactoryUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    //传统的获取javabean方法 直接new一个
    //弊端：如果接口的实现需要更换很多地方都得修改代码
    @Test
    public void test(){
        GetSource getSource = new GetMysqlSourceImpl();
        getSource.get();
        getSource.delete();
    }

    //通过工厂模式创建javabean
    //好处：如果接口的实现需要更换只需要修改工厂中的帮忙实例化的类getSource()
    //弊端：还是需要修改源代码
    @Test
    public void test1(){
        GetSource source = FactoryUtils.getSource();
        source.get();
        source.delete();
    }

    //通过spring的ioc模式创建对象
    //优点：可以直接配置的方式切换接口 无需修改源码
    //注意：有2种方式读取xml来反射生成javabean：
    //     一种是FileSystemXmlApplicationContext 当applicationContext.xml放其他盘符的时候使用
    //     一种是ClassPathXmlApplicationContext  直接找资源目录读取applicationContext.xml
    @Test
    public void test2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        GetSource source = (GetSource)ac.getBean("getSource");
        source.delete();
        source.get();
    }

    //DI：直接在applicationContext.xml配置javabean的属性
    //注入javabean的属性 需要提供该属性的set方法
    @Test
    public void test3(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        GetSource source = (GetSource)ac.getBean("getMysqlSourceImpl");
        source.get();
    }
}
