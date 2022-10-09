package com.itg.springMVC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //异常如果都没有在对应的类捕获进行处理 最终会来到标注@ControllerAdvice的类进行处理
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
