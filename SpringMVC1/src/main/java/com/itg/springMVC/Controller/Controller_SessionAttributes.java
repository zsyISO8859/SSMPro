package com.itg.springMVC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
//@SessionAttributes(value={"name","age"})   ָ����model�д���session�п��Թ����������������key
@SessionAttributes(types = {String.class})   //����String���͵����ݶ���model�д���session�п��Թ�����������
public class Controller_SessionAttributes {
    @RequestMapping("SessionAttributes")
    public String SessionAttributes(Model model) {
        model.addAttribute("name", "zsy77");
        model.addAttribute("age", "99");
        return "SessionAttributes.jsp";
    }

    //1.������SessionAttributes ��Ϊ@SessionAttributes���model�е����ݷŽ�session��
    //2.����������������SessionAttributes ������SessionAttributes1�Ϳ����ڶ�������й���������
    @RequestMapping("SessionAttributes1")
    public String SessionAttributes1() {
        return "SessionAttributes.jsp";
    }

    //@SessionAttribute ����ȡ������session������
    @RequestMapping("SessionAttribute")
    public String SessionAttribute(@SessionAttribute("name")String name) {
        System.out.println(name);
        return "SessionAttributes.jsp";
    }
}
