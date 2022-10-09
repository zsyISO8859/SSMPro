package com.itg.springMVC.Controller;

import com.itg.springMVC.domain.Goods;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;

//ֵ���ݷ�ʽ
@Controller
public class Controller_SendValue {
    @RequestMapping("sendValue")
    public String sendValue(Model model){
        model.addAttribute("name","itlike");
        System.out.println(model.asMap());
        return "second.jsp";
    }

    //model��addAttribute�����һ���淶�շ������Ķ������Ὣ�����������ĸСд��Ϊ��ֵ�Ե�key ������Ϊvalue
    @RequestMapping("sendValue1")
    public String sendValue1(Model model){
        Goods myGoods = new Goods();
        myGoods.setName("zsy");
        myGoods.setPrice("12");
        model.addAttribute(myGoods);
        System.out.println(model.asMap());
        return "sendValueRes.jsp";
    }

    //addAllAttributes�����Ϊmap���Խ�attributes�еĶ������ӵ�model�� ���model������ͬkey�ľ͸���
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

    //addAllAttributes�����Ϊ���� �Ὣ�����е��������ݸ��Ƶ�model�У�����������Ϊkey����ͬ�������������ݻḲ��ȡ���һ��
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

    //mergeAttributes���� ��attributes�е����ݸ��Ƶ�model�� ����ظ��򲻻Ḳ��
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

    //mergeAttributes���� ��attributes�е����ݸ��Ƶ�model�� ����ظ��򲻻Ḳ��
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
