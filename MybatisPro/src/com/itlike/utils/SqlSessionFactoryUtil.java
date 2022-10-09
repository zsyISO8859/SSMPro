package com.itlike.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtil {
    public static final SqlSessionFactory sessionFactory;

    static {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("sqlMappingConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
    }

    public static SqlSession openSession() {
        return sessionFactory.openSession();
    }
}
