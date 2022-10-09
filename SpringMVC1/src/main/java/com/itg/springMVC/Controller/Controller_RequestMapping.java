package com.itg.springMVC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Controller_RequestMapping {
    //可以多个路径访问同一个方法
    @RequestMapping(value = {"action1", "action2"})
    public String action() {
        System.out.println("action......");
        return "/second";
    }

    //method作用：设置可访问方式 默认支持post和get
    // 若设置了访问方式前端就得遵循否则报错： HTTP Status 405 - Request method 'POST' not supported
    @RequestMapping(value = "action3", method = {RequestMethod.GET, RequestMethod.POST})
    public String action3() {
        System.out.println("enter");
        return "/second";
    }

    //params作用: 满足params的内部条件才允许请求本方法
    @RequestMapping(value = "action4", params = {"name=itlike", "age!=1"})
    public String action4() {
        System.out.println("enter");
        return "/second";
    }

    //header作用：满足设定的header值才能请求本方法
    @RequestMapping(value = "action5", headers = {
            "Host=localhost:8080",
            "Referer=http://localhost:8080/SpringMVC1_war_exploded/requestmapping.jsp"})
    public String action5() {
        System.out.println("enter");
        return "/second";
    }

    //ant风格地址作用：？匹配一个字符 *匹配任意字符 **匹配多重路径
    @RequestMapping(value = "**/action6/??")
    public String action6() {
        System.out.println("enter");
        return "/second";
    }

    
}
