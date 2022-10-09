package com.proxy.controller;

import com.proxy.domain.Goods;
import org.junit.Test;

public class ProxyCglibTest {
    @Test
    public void test(){
        Goods goods = new Goods();
        ProxyCglibFactory proxyCglibFactory = new ProxyCglibFactory();
        Goods cglibDomain = proxyCglibFactory.getCglibDomain(goods);
        cglibDomain.save();
        cglibDomain.update();
    }
}
