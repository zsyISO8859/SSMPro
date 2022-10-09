package com.example.dao.impl;

import com.example.dao.GetSource;

public class GetMysqlSourceImpl implements GetSource {
    public String name;

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public void get() {
        System.out.println(name);
        System.out.println("GetMysqlSourceImpl::get");
    }

    @Override
    public void delete() {
        System.out.println("GetMysqlSourceImpl::delete");
    }
}
