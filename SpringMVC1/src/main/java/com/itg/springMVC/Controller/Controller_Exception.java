package com.itg.springMVC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller_Exception {

    // �����쳣��,�����ұ�������û�б�ע@ExceptionHandler�ķ���
    // �еĻ����ռ̳й�ϵ�ȽϽ���ArithmeticException\RuntimeException\Exceptionִ��
    // û�еĻ� ���б�ע@ControllerAdvice���ఴ�ռ̳й�ϵ�ȽϽ���ִ��
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
