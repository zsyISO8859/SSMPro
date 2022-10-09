package com.itg.springMVC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//ant风格
@Controller
public class Controller_Rest {
    @RequestMapping("/rest/{id}")
    public String ant(@PathVariable Integer id) {
        System.out.println(id);
        return "/second";
    }

    //从tomcat8开始如果restful风格请求直接返回页面会报405错误  JSPs only permit GET POST or HEAD
    //所以这里通过重定向解决问题。
    @RequestMapping(value = "/rest1/{id}", method = {RequestMethod.DELETE,RequestMethod.PUT})
    public String rest1(@PathVariable Integer id, Model model) {
        System.out.println(id);
        System.out.println(model.asMap());
        return "redirect:/res";
    }
    @RequestMapping("res")
    public String res() {
        return "/second.jsp";
    }

    
}
