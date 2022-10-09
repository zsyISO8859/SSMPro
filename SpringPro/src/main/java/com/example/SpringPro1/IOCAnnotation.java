package com.example.SpringPro1;

import com.example.domain.Person;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * XML：XML可以适用于任何场景 结构清晰 维护方便
 * 注解： 注解不是自己的类用不了 开发简单
 */

public class IOCAnnotation {
    @Test
    public void test(){
        ClassPathXmlApplicationContext ca = new ClassPathXmlApplicationContext("applicationContextPro1.xml");
        Person person = (Person)ca.getBean("person");
        System.out.println(person);
        System.out.println(person.personName);
        System.out.println(person.age);

    }
    @Test
    public void test1(){
        ClassPathXmlApplicationContext ca = new ClassPathXmlApplicationContext("applicationContextPro1.xml");
        Person person = (Person)ca.getBean("person");
        Person person1 = (Person)ca.getBean("person");
        //复杂属性注入Autowired  根据类型注入
        System.out.println(person.pet.petName);
        System.out.println(person.pet.age);

        //多例模式 获取对象地址不一样
        System.out.println(person.dog.name);
        System.out.println(person1);

    }

    //目前多例模式，调用工厂的close不会销毁对象 gc会自动销毁
    //@PostConstruct、@PreDestroy  2个注解是分别在对象的初始化和销毁的时候调用
    @Test
    public void test2(){
        ClassPathXmlApplicationContext ca = new ClassPathXmlApplicationContext("applicationContextPro1.xml");
        Person person = (Person)ca.getBean("person");
        ca.close();
    }
}
