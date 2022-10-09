package com.itlike.test;

import com.itlike.domain.Customer;
import com.itlike.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatis_SqlSessionFactoryBuild {
    @Test
    public void test(){
        //1.获取sql工厂builder
        SqlSessionFactoryBuilder ssb = new SqlSessionFactoryBuilder();

        //2.获取mybatis xml配置文件
        InputStream resourceAsStream =null;
        try {
             resourceAsStream = Resources.getResourceAsStream("sqlMappingConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //3.使用builder对配置文件进行构建
        SqlSessionFactory sessionFactory = ssb.build(resourceAsStream);

        //4.开启一个会话
        SqlSession sqlSession = sessionFactory.openSession();

        //5.sql处理
        Customer queryCustomerById = sqlSession.selectOne("queryCustomerById", 1);
        System.out.println(queryCustomerById);

        //6.关闭会话释放资源
        sqlSession.close();
    }

    //将可以复用的代码抽成一个工具类
    //SqlSessionFactoryBuilder只需要加载一次 无需重复加载
    //SqlSessionFactory一旦创建了可以重复使用 通常单例模式管理
    //SqlSession实例无法共享 线程不安全
    @Test
    public void test1(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        Customer customer = sqlSession.selectOne("queryCustomerById", 1);
        System.out.println(customer);
        sqlSession.close();
    }

    //#{}可以防止sql注入 后面会被替换为占位符？ 最终被替换成‘’
    //${}不可以放在sql注入 直接拼接
    //使用#{}传递参数 只有1个参数的时候参数名字可以随意写
    @Test
    public void test2(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        List<Customer> customer = sqlSession.selectList("queryCustomerByName", "%李%");
        customer.stream().forEach(System.out::println);
        sqlSession.close();
    }

    //使用${}传递参数 只有1个参数的时候参数名字一定得写value
    @Test
    public void test3(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        List<Customer> customer = sqlSession.selectList("queryCustomerByName1", "李");
        customer.stream().forEach(System.out::println);
        sqlSession.close();
    }

    //测试新增 且获取新增单据的id
    @Test
    public void test4(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        Customer customer = sqlSession.selectOne("queryCustomerById", 2);
        customer.setCust_name("郑勇鹏");
        customer.setCust_profession("二逼");
        sqlSession.insert("insertCustomer",customer);
        System.out.println(customer.getCust_id());
        sqlSession.commit();
        sqlSession.close();
    }

    //删
    @Test
    public void test5(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        Customer customer = sqlSession.selectOne("queryCustomerById", 14);
        sqlSession.delete("deleteCustomer",customer);
        sqlSession.commit();
        sqlSession.close();
    }

    //改
    @Test
    public void test6(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        Customer customer = sqlSession.selectOne("queryCustomerById", 10);
        customer.setCust_name("真勇");
        customer.setCust_phone("110");
        sqlSession.update("updateCustomer",customer);
        sqlSession.commit();
        sqlSession.close();
    }
}
