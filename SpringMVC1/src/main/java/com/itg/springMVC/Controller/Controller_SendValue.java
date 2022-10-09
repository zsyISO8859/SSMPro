package com.itg.springMVC.Controller;

import com.itg.springMVC.domain.Goods;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;

//值传递方式
@Controller
public class Controller_SendValue {
    @RequestMapping("sendValue")
    public String sendValue(Model model){
        model.addAttribute("name","itlike");
        System.out.println(model.asMap());
        return "second.jsp";
    }

    //model的addAttribute如果放一个规范驼峰命名的对象，他会将类的类名首字母小写作为键值对的key 数据作为value
    @RequestMapping("sendValue1")
    public String sendValue1(Model model){
        Goods myGoods = new Goods();
        myGoods.setName("zsy");
        myGoods.setPrice("12");
        model.addAttribute(myGoods);
        System.out.println(model.asMap());
        return "sendValueRes.jsp";
    }

    //addAllAttributes的入参为map可以将attributes中的东西复杂到model中 如果model中有相同key的就覆盖
    @RequestMapping("sendValue2")
    public String sendValue2(Model model){
        model.addAttribute("name","itlike");
        HashMap hashMap = new HashMap();
        hashMap.put("name","zsy");
        hashMap.put("age","20");
        model.addAllAttributes(hashMap);
        System.out.println(model.asMap());
        return "sendValueRes.jsp";
    }

    //addAllAttributes的入参为集合 会将集合中的所有数据复制到model中，以数据类型为key，相同的数据类型数据会覆盖取最后一个
    @RequestMapping("sendValue3")
    public String sendValue3(Model model){
        model.addAttribute("name","itlike");
        model.addAttribute("age","10");
        ArrayList list = new ArrayList();
        list.add("itlike001");
        list.add("zsy");
        list.add(1);
        model.addAllAttributes(list);
        System.out.println(model.asMap());
        return "sendValueRes.jsp";
    }

    //mergeAttributes方法 将attributes中的数据复制到model中 如果重复则不会覆盖
    @RequestMapping("sendValue4")
    public String sendValue4(Model model){
        model.addAttribute("name","itlike");
        model.addAttribute("age","10");

        HashMap hashMap = new HashMap();
        hashMap.put("name","zsy");
        hashMap.put("agee","20");
        model.mergeAttributes(hashMap);
        System.out.println(model.asMap());
        return "sendValueRes.jsp";
    }

    //mergeAttributes方法 将attributes中的数据复制到model中 如果重复则不会覆盖
    @RequestMapping("sendValue5")
    public String sendValue5(Model model){
        model.addAttribute("name","itlike");
        model.addAttribute("age","10");
        System.out.println(model.containsAttribute("name"));
        System.out.println(model.containsAttribute("agee"));
        System.out.println(model.asMap());
        return "sendValueRes.jsp";
    }

}
