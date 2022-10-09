package com.itg.springMVC.Controller;

import org.aopalliance.intercept.Interceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//拦截器首先要实现HandlerInterceptor接口 再配置springmvc的拦截器信息
//多个拦截器执行顺序 preHandle按顺序 postHandle、afterCompletion是倒序
public class MyFirstInterceptor implements HandlerInterceptor {

    //如果返回值为false会阻止下面的拦截器方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle1");
        return true;
    }

    //如果访问的请求发生了异常则不会进入此方法，会进入处理异常的方法
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle1");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion1");
    }
}
