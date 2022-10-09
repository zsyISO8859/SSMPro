package com.example.dao.impl;

import com.example.dao.GetSource;

public class GetOracleSourceImpl implements GetSource {
    @Override
    public void get() {
        System.out.println("GetOracleSourceImpl::get");
    }

    @Override
    public void delete() {
        System.out.println("GetOracleSourceImpl::delete");
    }
}
