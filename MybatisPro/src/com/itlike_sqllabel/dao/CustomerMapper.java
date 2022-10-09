package com.itlike_sqllabel.dao;

import com.itlike_params.domain.Customer;
import com.itlike_sqllabel.domain.QueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface CustomerMapper {
    Customer findByContent(@Param("cust_id") Integer cust_id, @Param("cust_name") String cust_name);
    Customer findByContent1(@Param("cust_id") Integer cust_id, @Param("cust_name") String cust_name);
    Customer findByContent2(@Param("cust_id") Integer cust_id, @Param("cust_name") String cust_name);
    List<Customer> findByContent3(Integer[] ids);
    List<Customer> findByContent4(List ids);
    List<Customer> findByContent5(QueryVo queryVo);
    List<Customer> findByContent6(QueryVo queryVo);

}
