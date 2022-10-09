package com.example.SpringPro;

import com.example.dao.GetSource;
import com.example.domain.Dog;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//分模块配置
public class SpringSubModuleSet {

    //采取导入多个xml文件的方式加载javabean
    @Test
    public void test(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml","applicationContext1.xml");
        GetSource source = (GetSource)ac.getBean("getMysqlSourceImpl");
        Dog dog = (Dog)ac.getBean("dog");
    }

    //采取在主xml中引入分模块xml的方式
    @Test
    public void test1(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        GetSource source = (GetSource)ac.getBean("getMysqlSourceImpl");
        Dog dog = (Dog)ac.getBean("dog");
    }

}
