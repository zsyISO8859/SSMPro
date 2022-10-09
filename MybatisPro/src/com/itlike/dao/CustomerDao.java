package com.itlike.dao;

import com.itlike.domain.Customer;

import java.util.List;

public interface CustomerDao {
    public Customer getOne(Integer id);

    public List<Customer> getAll();

    public void insert(Customer customer);

    public void update(Customer customer);

    public void delete(Customer id);

}
