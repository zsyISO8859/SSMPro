package com.itg.springMVC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller_CookieValue {
    //cookie�洢�ڿͻ��� ������Ϣ��С���޵���cookieֻ��4kb ����ȫ��Ϣ���ױ���ȡ�ʹ۸�
    //session�洢�ڷ����� �û����ʻὫsessionid�洢���������cookie�У��´�ͨ��seesionid��ȡ����˵��û����� �����û���ʱ��ռ�÷�������Դ��
    //CookieValue���ã���������������������͹�����cookieֵ
    @RequestMapping("testCookie")
    public String requestHeader(@CookieValue("JSESSIONID") String sessionid) {
        System.out.println(sessionid);
        return "second.jsp";
    }
}
