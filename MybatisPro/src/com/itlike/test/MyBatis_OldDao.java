package com.itlike.test;

import com.itlike.dao.CustomerDao;
import com.itlike.dao.CustomerDaoImpl;
import com.itlike.domain.Customer;
import org.junit.Test;

import java.util.List;

public class MyBatis_OldDao {
    @Test
    public void save(){
        CustomerDao customerDao = new CustomerDaoImpl();
        Customer customer = new Customer();
        customer.setCust_name("lya");
        customer.setCust_phone("110");
        customer.setCust_profession("吃鸡");
        customer.setEmail("2250173633@qq.com");
        customerDao.insert(customer);
    }

    @Test
    public void update(){
        CustomerDao customerDao = new CustomerDaoImpl();
    }

    @Test
    public void delete(){
        CustomerDao customerDao = new CustomerDaoImpl();
        Customer customer = new Customer();
        customer.setCust_id(15);
        customerDao.delete(customer);
    }

    @Test
    public void find(){
        CustomerDao customerDao = new CustomerDaoImpl();
    }

    @Test
    public void findAll(){
        CustomerDao customerDao = new CustomerDaoImpl();
        List<Customer> all = customerDao.getAll();
        all.stream().forEach(System.out::println);
    }
}
