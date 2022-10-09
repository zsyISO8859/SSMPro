package com.itg.springMVC.Controller;

import com.itg.springMVC.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Controller_JSON {

    //@ResponseBody 作用：客户端可以json请求服务器的数据
    @RequestMapping("getJson")
    @ResponseBody
    public User getJson() {
        User user = new User();
        user.setName("zyp");
        user.setAge(25);
        user.setGender(1);
        return user;
    }

    @RequestMapping("getJsonList")
    @ResponseBody
    public List<User> getJsonList() {
        ArrayList<User> users = new ArrayList<>();
        User user = new User();
        user.setName("zyp");
        user.setAge(25);
        user.setGender(1);
        User user1 = new User();
        user1.setAge(20);
        user1.setName("ly");
        user1.setGender(0);

        users.add(user);
        users.add(user1);
        return users;
    }

    @RequestMapping("getJsonMap")
    @ResponseBody
    public Map<String,Object> getJsonMap() {
        Map<String, Object> maps = new HashMap<>();
        User user = new User();
        user.setName("zyp");
        user.setAge(25);
        user.setGender(1);
        User user1 = new User();
        user1.setAge(20);
        user1.setName("ly");
        user1.setGender(0);

        maps.put("user",user);
        maps.put("user1",user1);
        return maps;
    }

    @RequestMapping("formJson")
    @ResponseBody
    public HashMap<String, Object> formJson(@RequestBody User user){
        System.out.println(user);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("res","11");
        return hashMap;
    }

    @RequestMapping("sendJsonTest")
    @ResponseBody
    public HashMap<String, Object> sendJsonTest(@RequestBody User user){
        System.out.println(user);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("res","success");
        return hashMap;
    }
}
