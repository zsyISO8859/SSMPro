package com.itg.springMVC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //�쳣�����û���ڶ�Ӧ���ಶ����д��� ���ջ�������ע@ControllerAdvice������д���
public class Controller_ControllerAdvice {

    @ExceptionHandler(Exception.class)
    public void ExceptionTest(Exception e){
        System.out.println("Exception....");
    }

    @ExceptionHandler(RuntimeException.class)
    public void RuntimeExceptionTest(Exception e){
        System.out.println("RuntimeException....");
    }

    @ExceptionHandler(ArithmeticException.class)
    public void ArithmeticExceptionTest(Exception e){
        System.out.println("ArithmeticException....");
    }
}
