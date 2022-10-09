package com.itlike_params.dao;

import com.itlike_params.domain.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

public interface CustomerMapper {
    Customer findByID(Integer id);
    Customer findByParamIndex(@Param("id") Integer id,@Param("name") String name);
    Customer findByClassName(Customer customer);
    Customer findBySelfValue(Integer id ,String name);

    Customer findByMap(HashMap<String, Object> map);
}
