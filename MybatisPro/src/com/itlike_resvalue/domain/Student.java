package com.itlike_resvalue.domain;

import java.util.ArrayList;
import java.util.List;

public class Student {
    public Integer stu_id;
    public String stu_name;
    public List<Teach> teachList = new ArrayList<>();

    @Override
    public String toString() {
        return "Student{" +
                "stu_id=" + stu_id +
                ", stu_name='" + stu_name + '\'' +
                ", teachList=" + teachList +
                '}';
    }

    public List<Teach> getTeachList() {
        return teachList;
    }

    public void setTeachList(List<Teach> teachList) {
        this.teachList = teachList;
    }

    public Integer getStu_id() {
        return stu_id;
    }

    public void setStu_id(Integer stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }
}
