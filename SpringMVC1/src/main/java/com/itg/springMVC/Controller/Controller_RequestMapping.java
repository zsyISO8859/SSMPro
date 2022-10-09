package com.itg.springMVC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Controller_RequestMapping {
    //���Զ��·������ͬһ������
    @RequestMapping(value = {"action1", "action2"})
    public String action() {
        System.out.println("action......");
        return "/second";
    }

    //method���ã����ÿɷ��ʷ�ʽ Ĭ��֧��post��get
    // �������˷��ʷ�ʽǰ�˾͵���ѭ���򱨴� HTTP Status 405 - Request method 'POST' not supported
    @RequestMapping(value = "action3", method = {RequestMethod.GET, RequestMethod.POST})
    public String action3() {
        System.out.println("enter");
        return "/second";
    }

    //params����: ����params���ڲ��������������󱾷���
    @RequestMapping(value = "action4", params = {"name=itlike", "age!=1"})
    public String action4() {
        System.out.println("enter");
        return "/second";
    }

    //header���ã������趨��headerֵ�������󱾷���
    @RequestMapping(value = "action5", headers = {
            "Host=localhost:8080",
            "Referer=http://localhost:8080/SpringMVC1_war_exploded/requestmapping.jsp"})
    public String action5() {
        System.out.println("enter");
        return "/second";
    }

    //ant����ַ���ã���ƥ��һ���ַ� *ƥ�������ַ� **ƥ�����·��
    @RequestMapping(value = "**/action6/??")
    public String action6() {
        System.out.println("enter");
        return "/second";
    }

    
}
