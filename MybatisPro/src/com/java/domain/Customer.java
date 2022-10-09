package com.java.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * customer
 * @author 
 */
@Data
public class Customer implements Serializable {
    private Integer custId;

    private String custName;

    private String custProfession;

    private String custPhone;

    private String email;

    private static final long serialVersionUID = 1L;
}