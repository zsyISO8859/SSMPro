package com.itlike_resvalue.test;

import com.itlike.utils.SqlSessionFactoryUtil;

import com.itlike_resvalue.dao.CustomerMapper;
import com.itlike_resvalue.domain.Customer;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

//指定mybatis的返回值类型
public class MyBatisRes {

    //resultType要求必须得要字段名称和数据库当中的名称一致时才能有值,否则为null
    @Test
    public void test(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        //查询出简单类型Integer
        Integer count = mapper.findCount();
        //只查询出一条数据，数据的field和value用Map进行展示。
        Map<String, Customer> customerMap = mapper.findCustomerMap(2);
        //查询出全部数据，封装成以id为key以Customer对象为value的Map  需要在接口Mapper上指定key是什么 例：@MapKey("cust_id")
        Map<Integer, Customer> allCustomerMap = mapper.getAllCustomerMap();

        Stream.of(allCustomerMap).forEach(System.out::println);
        System.out.println("---------------------------");
        Stream.of(customerMap).forEach(System.out::println);
        System.out.println("---------------------------");
        System.out.println(count);
        sqlSession.close();
    }

    //之前在写输出时使用的都是resultType
    //但是resultType要求必须得要字段名称和数据库当中的名称一致时才能有值,否则为null
    //如果sql查询字段名和pojo的属性名不一致，可以通过resultMap将字段名和属性名作一个对应关系
    @Test
    public void test1(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        //使用resultMap封装查询返回值 需要用List接收数据
        List<Customer> allCustomerMap = mapper.findAllCustomerMap();
        Stream.of(allCustomerMap).forEach(System.out::println);

        sqlSession.close();
    }
}
