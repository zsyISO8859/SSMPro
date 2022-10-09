package com.itg.springMVC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller_Exception {

    // 发生异常了,会先找本类中有没有标注@ExceptionHandler的方法
    // 有的话按照继承关系比较进的ArithmeticException\RuntimeException\Exception执行
    // 没有的话 找有标注@ControllerAdvice的类按照继承关系比较近的执行
    @RequestMapping("testException")
    public String testException(){
        int i=1/0;
        return "second.jsp";
    }

    @RequestMapping("test")
    public String test(){
        return "second.jsp";
    }

    @RequestMapping("test1")
    public String test1(){
        return "second.jsp";
    }
}
