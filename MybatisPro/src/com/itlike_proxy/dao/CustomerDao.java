package com.itlike_proxy.dao;

import com.itlike_proxy.domain.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> getAllCustomer();
    Customer queryCustomerWithId(Integer id);
    void insertOneCustomer(Customer customer);
}
