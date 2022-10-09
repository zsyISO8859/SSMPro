package com.example.dao.impl;

import com.example.dao.GoodDao;
import org.springframework.stereotype.Repository;

@Repository("goodsDao")
public class GoodsDaoImpl implements GoodDao {
    @Override
    public void getGoods() {
        System.out.println("getGoods-----------------");
    }
}
