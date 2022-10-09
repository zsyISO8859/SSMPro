package com.itg.springMVC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller_MulUrlRequest {
    @RequestMapping(value = {"request","request1","request2"})
    public String test(){
        System.out.println("enter");
        return "/second";
    }
}
