package com.itg.springMVC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller_RequestHeader {
    //RequestHeader����: �������header����ע�뵽������
    @RequestMapping("requestHeader")
    public String requestHeader(@RequestHeader("Referer")String referer, Model model,@RequestHeader("Connection")String asd) {
        System.out.println(referer);
        System.out.println(model.asMap());
        System.out.println(asd);
        return "second.jsp";
    }
}
