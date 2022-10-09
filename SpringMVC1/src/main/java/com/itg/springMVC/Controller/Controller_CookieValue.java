package com.itg.springMVC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller_CookieValue {
    //cookie存储在客户端 保存信息大小受限单个cookie只有4kb 不安全信息容易被读取和篡改
    //session存储在服务器 用户访问会将sessionid存储到浏览器的cookie中，下次通过seesionid获取服务端的用户数据 访问用户多时候占用服务器资源多
    //CookieValue作用：用来接收浏览器传给发送过来的cookie值
    @RequestMapping("testCookie")
    public String requestHeader(@CookieValue("JSESSIONID") String sessionid) {
        System.out.println(sessionid);
        return "second.jsp";
    }
}
