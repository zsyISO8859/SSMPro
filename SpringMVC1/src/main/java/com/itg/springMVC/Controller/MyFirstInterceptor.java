package com.itg.springMVC.Controller;

import org.aopalliance.intercept.Interceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//����������Ҫʵ��HandlerInterceptor�ӿ� ������springmvc����������Ϣ
//���������ִ��˳�� preHandle��˳�� postHandle��afterCompletion�ǵ���
public class MyFirstInterceptor implements HandlerInterceptor {

    //�������ֵΪfalse����ֹ���������������
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle1");
        return true;
    }

    //������ʵ����������쳣�򲻻����˷���������봦���쳣�ķ���
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle1");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion1");
    }
}
