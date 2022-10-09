package com.itg.springMVC.Controller;

import com.itg.springMVC.domain.Dog;
import com.itg.springMVC.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class Controller_Label {

    //ע��㣺
    // 1.ǰ���ñ�ǩfm�������ݺ�˱���Ҫ��֤���ݵ������ԣ���Ȼ�������ݻᱨ��
    // 2.����model��������Щ��Ҫ��${}��ȡ����
    // 3.fm��ǩ֧�ֳ���post��get֮��ķ��������ύ������put��delete
    @RequestMapping(value = "update")
    public String label(Model model) {
        System.out.println(model.asMap());
        User user = new User();
        user.setName("zsy");
        user.setAge(20);
        user.setGender(1);
        user.setHobby(new String[]{"����","ƹ����"});

        ArrayList<Dog> dogs = new ArrayList<>();
        Dog dog = new Dog();
        dog.setId(0);
        dog.setName("zyp");
        dog.setColor("green");
        Dog dog1 = new Dog();
        dog1.setId(1);
        dog1.setName("lsj");
        dog1.setColor("yellow");
        Dog dog2 = new Dog();
        dog2.setId(2);
        dog2.setName("ly");
        dog2.setColor("red");
        dogs.add(dog);
        dogs.add(dog1);
        dogs.add(dog2);
        model.addAttribute("petList",dogs);

        user.setPet(dog);

        ArrayList<String> list = new ArrayList<>();
        list.add("����");
        list.add("����");
        list.add("ƹ����");
        model.addAttribute("hobbyList",list);

        model.addAttribute(user);
        return "labelRes.jsp";
    }

    @RequestMapping(value = "update2")
    public String label2(@Valid User user, BindingResult bindingResult,Model model) {
        //System.out.println(model.asMap());
        if(bindingResult.getErrorCount()!=0) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                System.out.println(fieldError.getField() + ":" + fieldError.getDefaultMessage());
                model.addAttribute(fieldError.getField(),fieldError.getDefaultMessage());
            }
        }
        return "second.jsp";
    }
}
