package com.itg.springMVC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
//@SessionAttributes(value={"name","age"})   指定从model中存入session中可以供各个请求共享的数据key
@SessionAttributes(types = {String.class})   //满足String类型的数据都从model中存入session中可以供各个请求共享
public class Controller_SessionAttributes {
    @RequestMapping("SessionAttributes")
    public String SessionAttributes(Model model) {
        model.addAttribute("name", "zsy77");
        model.addAttribute("age", "99");
        return "SessionAttributes.jsp";
    }

    //1.先请求SessionAttributes 因为@SessionAttributes会把model中的数据放进session中
    //2.所以先请求先请求SessionAttributes 再请求SessionAttributes1就可以在多个请求中共享数据了
    @RequestMapping("SessionAttributes1")
    public String SessionAttributes1() {
        return "SessionAttributes.jsp";
    }

    //@SessionAttribute 可以取到存在session的数据
    @RequestMapping("SessionAttribute")
    public String SessionAttribute(@SessionAttribute("name")String name) {
        System.out.println(name);
        return "SessionAttributes.jsp";
    }
}
