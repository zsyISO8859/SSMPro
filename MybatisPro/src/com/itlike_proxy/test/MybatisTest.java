package com.itlike_proxy.test;

import com.itlike.utils.SqlSessionFactoryUtil;
import com.itlike_proxy.dao.CustomerDao;
import com.itlike_proxy.domain.Customer;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MybatisTest {
    @Test
    public void queryAll(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        sqlSession.getMapper(CustomerDao.class);
        List<Customer> customer = sqlSession.selectList("getAllCustomer");
        customer.stream().forEach(System.out::println);
    }

    //注意点：
    // 新增数据库映射xml需要在mybatis的xml配置文件加入mapper映射
    // 不同的mapper之间的id不能一样 不然会报错
    @Test
    public void queryOne(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        sqlSession.getMapper(CustomerDao.class);
        Customer customer = sqlSession.selectOne("queryCustomerWithId", 12);
        System.out.println(customer);
    }

    @Test
    public void insertCustomer(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        sqlSession.getMapper(CustomerDao.class);
        Customer customer = sqlSession.selectOne("queryCustomerWithId", 2);
        sqlSession.insert("insertOneCustomer",customer);
        sqlSession.commit();
        sqlSession.close();
    }
}
