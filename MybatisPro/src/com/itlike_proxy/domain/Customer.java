package com.itlike_proxy.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
    public Integer cust_id;
    public String cust_name;
    public String cust_profession;
    public String cust_phone;
    public String email;

    public Integer getCust_id() {
        return cust_id;
    }

    public void setCust_id(Integer cust_id) {
        this.cust_id = cust_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getCust_profession() {
        return cust_profession;
    }

    public void setCust_profession(String cust_profession) {
        this.cust_profession = cust_profession;
    }

    public String getCust_phone() {
        return cust_phone;
    }

    public void setCust_phone(String cust_phone) {
        this.cust_phone = cust_phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cust_id=" + cust_id +
                ", cust_name='" + cust_name + '\'' +
                ", cust_profession='" + cust_profession + '\'' +
                ", cust_phone='" + cust_phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
