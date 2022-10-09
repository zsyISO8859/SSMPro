package com.example.factory;

import com.example.dao.GetSource;
import com.example.dao.impl.GetMysqlSourceImpl;

public  class  FactoryUtils {
    public static GetSource getSource(){
        return new GetMysqlSourceImpl();
    }
}
