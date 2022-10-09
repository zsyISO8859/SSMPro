package com.itlike_resvalue.domain;

import java.util.Date;
import java.util.List;

public class Order {
    public Integer order_id;
    public String order_num;
    public String order_note;
    public String cus_id;
    public Date order_time;
    public Customer customer;

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", order_num='" + order_num + '\'' +
                ", order_note='" + order_note + '\'' +
                ", cus_id='" + cus_id + '\'' +
                ", order_time=" + order_time +
                ", customer=" + customer +
                '}';
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getOrder_num() {
        return order_num;
    }

    public void setOrder_num(String order_num) {
        this.order_num = order_num;
    }

    public String getOrder_note() {
        return order_note;
    }

    public void setOrder_note(String order_note) {
        this.order_note = order_note;
    }

    public String getCus_id() {
        return cus_id;
    }

    public void setCus_id(String cus_id) {
        this.cus_id = cus_id;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }
}
