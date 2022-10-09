package com.example.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Pet {
    @Value("郑勇鹏")
    public String petName;
    @Value("25")
    public Integer age;
}
