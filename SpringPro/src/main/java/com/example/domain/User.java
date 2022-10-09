package com.example.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private String name;
    private Dog dog;
    private String str[];
    private List hobby;
    private Set set;
    private Map map;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", dog=" + dog +
                ", str=" + Arrays.toString(str) +
                ", hobby=" + hobby +
                ", set=" + set +
                ", map=" + map +
                '}';
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setHobby(List hobby) {
        this.hobby = hobby;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStr(String[] str) {
        this.str = str;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public User(){
        System.out.println("调用了默认的构造函数....");
    }

    public void init(){
        System.out.println("User-init");
    }
    public void destroy(){
        System.out.println("User-destroy");
    }
    public static User createUser(){
        System.out.println("createUser....");
        return new User();
    }

}
