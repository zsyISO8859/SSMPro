package com.itlike_sqllabel.domain;

import java.util.List;

public class QueryVo {
    private Customer customer;
    private Integer[] voids;
    private List<String> volist;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer[] getVoids() {
        return voids;
    }

    public void setVoids(Integer[] voids) {
        this.voids = voids;
    }

    public List<String> getVolist() {
        return volist;
    }

    public void setVolist(List<String> volist) {
        this.volist = volist;
    }
}
