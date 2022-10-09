package com.itg.springMVC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//ant���
@Controller
public class Controller_Rest {
    @RequestMapping("/rest/{id}")
    public String ant(@PathVariable Integer id) {
        System.out.println(id);
        return "/second";
    }

    //��tomcat8��ʼ���restful�������ֱ�ӷ���ҳ��ᱨ405����  JSPs only permit GET POST or HEAD
    //��������ͨ���ض��������⡣
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
