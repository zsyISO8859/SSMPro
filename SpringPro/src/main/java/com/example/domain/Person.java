package com.example.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Component("person")//交给spring管理   Component衍生的三个注解@Controller：web层  @Service：service层  @Repository：dao层
@Scope("prototype") //作用范围：多例模式
public class Person {
    @Value("zsy")//注入简单类型
    public String personName;

    public Integer age;
    @Autowired //按照类类型注入:无需在Pet类上指定spring的管理id @Component  直接根据类型找当前扫描的包里面的这个类型
    public Pet pet;

    @Resource(name = "dog")
    public Dog dog;

    @Value("22")//也可以在set方法上面注入
    public void setAge(Integer age) {
        this.age = age;
    }

    @PostConstruct
    public void init(){
        System.out.println("init------");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("destroy------");
    }
}
