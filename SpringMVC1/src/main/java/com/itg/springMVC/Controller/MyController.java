package com.itg.springMVC.Controller;

import com.itg.springMVC.domain.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController {

    @RequestMapping("/first")
    public static ModelAndView first() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "zyp");
        modelAndView.setViewName("/second");
        return modelAndView;
    }

    @RequestMapping("/second")
    public static String second(){
        return "redirect:first.action";
    }

    //传统接收参数
    @RequestMapping("/third")
    public static String third(HttpServletRequest httpServletRequest){
        String id = httpServletRequest.getParameter("id");
        System.out.println(id);

        return "/second";
    }

    //传统接收参数
    @RequestMapping("/third1")
    public static String third1(Integer id,String name){

        System.out.println(id + name);

        return "/second";
    }

    //传统接收参数  value指定接收的参数名 requird指定是否必传，默认必传 defaultvalue指定默认值  【必传如果没传前端会报错】
    @RequestMapping("/third3")
    public static String third3(@RequestParam(value = "id",required = false,defaultValue = "10")Integer key, String name){

        System.out.println(key + name);

        return "/second";
    }

    //以javaBean对象接收
    @RequestMapping(value = {"third2","third4"})
    public static String third2(Users users){
        System.out.println(users);
        return "/second";
    }
}
