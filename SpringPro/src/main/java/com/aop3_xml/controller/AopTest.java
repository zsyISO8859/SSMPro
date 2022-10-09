package com.aop3_xml.controller;

import com.aop3_xml.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


//自动加载配置文件
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContextPro3.xml")
public class AopTest {
    @Resource(name = "user")
    User user;

    @Test
    public void aopTest() {
        user.save();  //before 切入点调用之前调用
        user.update(); //around 切入点调用之前调用之后都可以执行一些操作
        user.delete(); //after-returning 切入点调用完毕后调用
        user.find(); //after-throwing 有异常才会调用
        user.finish(); //after  最终调用
    }
}
