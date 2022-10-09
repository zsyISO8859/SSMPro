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

    //ϵͳ���Զ���User����һ�ݸ�model
    @RequestMapping("ModelAttribute")
    public String ModelAttribute(Users users, Model model) {
        System.out.println(users);
        System.out.println(model.asMap());
        return "SessionAttributes.jsp";
    }

    //ϵͳ���Զ���User���ݵ�key�ĳ�xq����һ�ݸ�model
    @RequestMapping("ModelAttribute1")
    public String ModelAttribute1(@ModelAttribute("xq") Users users, Model model) {
        System.out.println(users);
        System.out.println(model.asMap());
        return "SessionAttributes.jsp";
    }

    //ModelAttribute�ŷ������������ӳ�䷽��֮ǰ�ȷ��ʱ�����
    //�ڽ��뱾����֮ǰ���session���е����ݸ���һ�ݵ���ǰ��model��
    //��ʱ����model����������� �������key��ӳ�䷽����keyһ��ֵ�ͻᱻӳ�䷽������ȫ����
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

    //�˷������Ա�ModelAttribute��ǵķ����Ƿ��ڽ��뷽����ʱ��ͽ�session�е����ݴ���model��
    @RequestMapping("ModelAttribute2")
    public String ModelAttribute2(@ModelAttribute("model") Users users, Model model) {
        model.addAttribute("store","aaaaaaa");
        System.out.println(model.asMap());
        return "SessionAttributes.jsp";
    }

    //��@ModelAttribute��ǩ���κ� ǰ�÷�����key�ʹ˷�����keyֵ��ͬʱ���ȡ�ĸ��Ǿ��ǲ���ȫ����
    @RequestMapping("ModelAttribute3")
    public String ModelAttribute3(@ModelAttribute("myxq") Users users, Model model) {
        System.out.println(users);
        System.out.println(model.asMap());
        return "SessionAttributes.jsp";
    }
}
