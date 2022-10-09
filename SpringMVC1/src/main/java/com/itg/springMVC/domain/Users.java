package com.itg.springMVC.domain;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Users {

    private String name;
    private Integer age;
    private String[] hobby;
    private Dog pet;
    private List<Dog> dogs;
    private Date bor;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobby=" + Arrays.toString(hobby) +
                ", pet=" + pet +
                ", dogs=" + dogs +
                ", bor=" + bor +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public Dog getPet() {
        return pet;
    }

    public void setPet(Dog pet) {
        this.pet = pet;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }

    public Date getBor() {
        return bor;
    }

    public void setBor(Date bor) {
        this.bor = bor;
    }
}
