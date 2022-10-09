package com.itlike_resvalue.dao;

import com.itlike_resvalue.domain.Customer;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CustomerMapper {
    Integer findCount();
    Map<String,Customer> findCustomerMap(Integer id);
    @MapKey("cust_id")
    Map<Integer, Customer> getAllCustomerMap();

    //通过resultMap方式包装数据
    List<Customer> findAllCustomerMap();

    Customer getCustomerWithId(Integer id);

    void saveCustomer(Customer customer);

    List<Customer> getAllCustomerContainRelOrder();

    void addCustomer(Customer customer);

    void updateRelaOrder(@Param("cus_id") Integer cus_id, @Param("order_id") Integer order_id);

    void deleteCustomer(@Param("cust_id") Integer cust_id);

    void deleteRelaOrder(@Param("cus_id") Integer cus_id);
}
