package com.itlike_params.test;

import com.itlike.utils.SqlSessionFactoryUtil;
import com.itlike_params.dao.CustomerMapper;
import com.itlike_params.domain.Customer;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;

//mybatis各种参数传递测试
public class MybatisParamsTest {

    //查询传递一个参数
    // 在sql的mapper中可写parameterType也可以不写 但是最好写
    @Test
    public void test(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = mapper.findByID(2);
        System.out.println(customer);
        sqlSession.close();
    }

    // 查询传递多个参数
    // 如果想使用自己在Dao中定义的名字 用@Param（“”）注解
    @Test
    public void test1(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = mapper.findByParamIndex(2,"李白");
        System.out.println(customer);
        sqlSession.close();
    }

    //查询传递参数-传递对象 在sql
    // mapper中可以直接用类的变量进行取值
    @Test
    public void test2(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer1 = new Customer();
        customer1.setCust_id(2);
        customer1.setCust_name("李白");
        Customer customer = mapper.findByClassName(customer1);
        System.out.println(customer);
        sqlSession.close();
    }

    //使用查询传递多个参数
    // 默认可以使用[arg1, arg0, param1, param2]
    @Test
    public void test3(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = mapper.findBySelfValue(2,"李白");
        System.out.println(customer);
        sqlSession.close();
    }

    //查询传递多个参数-map
    // 使用map可以直接以map的key当作参数的名字
    // 任意多个参数，都会被MyBatis重新包装成一个Map传入。
    @Test
    public void test4(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",2);
        map.put("name","李白");
        Customer customer = mapper.findByMap(map);
        System.out.println(customer);
        sqlSession.close();
    }
}
