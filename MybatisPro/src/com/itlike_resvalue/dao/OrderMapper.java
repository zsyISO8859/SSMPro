package com.itlike_resvalue.dao;

import com.itlike_resvalue.domain.Order;

import java.util.List;

public interface OrderMapper {
    List<Order> getAllOrder();
    List<Order> getAllOrder1();
    void insertOrder(Order order);

}
