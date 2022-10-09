package com.example.service.impl;

import com.example.dao.GoodDao;
import com.example.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
    @Resource(name = "goodsDao")
    GoodDao goodsDao;

    @Override
    public void goodsService() {
        goodsDao.getGoods();
    }
}
