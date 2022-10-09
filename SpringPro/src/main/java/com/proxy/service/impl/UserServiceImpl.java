package com.proxy.service.impl;

import com.proxy.dao.UserDao;
import com.proxy.dao.UserDaoImpl;
import com.proxy.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public void insert() {
        userDao.insert();
    }

    @Override
    public void delete() {
        userDao.delete();
    }
}
