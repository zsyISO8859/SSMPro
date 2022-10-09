package com.itlike.dao;

import com.itlike.domain.Customer;
import com.itlike.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public Customer getOne(Integer id) {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        return sqlSession.selectOne("queryCustomerById", id);
    }

    @Override
    public List<Customer> getAll() {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        List<Customer> customer = sqlSession.selectList("queryAll");
        return customer;
    }

    @Override
    public void insert(Customer customer) {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        sqlSession.insert("insertCustomer",customer);
        System.out.println(customer.getCust_id());
        sqlSession.commit();
    }

    @Override
    public void update(Customer customer) {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        sqlSession.update("updateCustomer",customer);
        sqlSession.commit();
    }

    @Override
    public void delete(Customer id) {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        sqlSession.delete("deleteCustomer",id);
        sqlSession.commit();
    }
}
