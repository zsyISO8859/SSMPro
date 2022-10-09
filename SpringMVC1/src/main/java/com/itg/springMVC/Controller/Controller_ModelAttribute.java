package com.itg.springMVC.Controller;

import com.itg.springMVC.domain.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;

@Controller
@SessionAttributes(value = {"store"})
public class Controller_ModelAttribute {

    //系统会自动把User复制一份给model
    @RequestMapping("ModelAttribute")
    public String ModelAttribute(Users users, Model model) {
        System.out.println(users);
        System.out.println(model.asMap());
        return "SessionAttributes.jsp";
    }

    //系统会自动把User数据的key改成xq复制一份给model
    @RequestMapping("ModelAttribute1")
    public String ModelAttribute1(@ModelAttribute("xq") Users users, Model model) {
        System.out.println(users);
        System.out.println(model.asMap());
        return "SessionAttributes.jsp";
    }

    //ModelAttribute放方法上面可以在映射方法之前先访问本方法
    //在进入本方法之前会把session域中的数据复制一份到当前的model中
    //这时候往model可以添加数据 但是如果key和映射方法的key一样值就会被映射方法的完全覆盖
    @ModelAttribute
    public String ModelAttribute1(Model model){
        System.out.println(model.asMap());
        Users users = new Users();
        users.setAge(2000);
        users.setName("qqqq");
        users.setBor(new Date());
        model.addAttribute("myxq", users);


        Users myGoods = new Users();
        myGoods.setAge(2000);
        myGoods.setName("qqqq");
        model.addAttribute("myGoods",myGoods);
        return "qwe";
    }

    //此方法测试被ModelAttribute标记的方法是否在进入方法的时候就将session中的数据存入model中
    @RequestMapping("ModelAttribute2")
    public String ModelAttribute2(@ModelAttribute("model") Users users, Model model) {
        model.addAttribute("store","aaaaaaa");
        System.out.println(model.asMap());
        return "SessionAttributes.jsp";
    }

    //被@ModelAttribute标签修饰后 前置方法的key和此方法的key值相同时候采取的覆盖就是不完全覆盖
    @RequestMapping("ModelAttribute3")
    public String ModelAttribute3(@ModelAttribute("myxq") Users users, Model model) {
        System.out.println(users);
        System.out.println(model.asMap());
        return "SessionAttributes.jsp";
    }
}
