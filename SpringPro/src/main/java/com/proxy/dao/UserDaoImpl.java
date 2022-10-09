package com.proxy.dao;

public class UserDaoImpl implements UserDao {
    @Override
    public void insert() {
        System.out.println("insert");
    }

    @Override
    public void delete() {
        System.out.println("delete");
    }
}
