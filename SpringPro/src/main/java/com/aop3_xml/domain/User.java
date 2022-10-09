package com.aop3_xml.domain;

public class User {
    public void save(){
        System.out.println("save");
    }

    public void update(){
        System.out.println("update");
    }

    public String delete(){
        System.out.println("delete");
        return "--res--success";
    }

    public void find(){
        int i = 1/0;
        System.out.println("find");
    }

    public void finish(){
        System.out.println("finish");
    }
}
