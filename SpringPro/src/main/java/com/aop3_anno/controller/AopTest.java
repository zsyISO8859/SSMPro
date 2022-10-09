package com.aop3_anno.controller;

import com.aop3_anno.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;

/**
 * MyAspect和MyAspect1 是不同的写法：
 * MyAspect将切点用execution表达式和通知定义在一块
 * MyAspect1将切点单独定义 方便在一个通知中引入多个切点
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContextPro4.xml")
public class AopTest {

    @Resource(name = "user")
    User user;

    @Test
    public void test() {
        user.save();
        //user.update();
        //user.delete();
        //user.find();
        //user.finish();
    }
}
