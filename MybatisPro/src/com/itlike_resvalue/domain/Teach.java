package com.itlike_resvalue.domain;

import java.util.ArrayList;
import java.util.List;

public class Teach {
    public Integer teach_id;
    public String teach_name;
    public List<Student> studentList = new ArrayList<>();

    @Override
    public String toString() {
        return "Teach{" +
                "teach_id=" + teach_id +
                ", teach_name='" + teach_name + '\'' +
                ", studentList=" + studentList +
                '}';
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Integer getTeach_id() {
        return teach_id;
    }

    public void setTeach_id(Integer teach_id) {
        this.teach_id = teach_id;
    }

    public String getTeach_name() {
        return teach_name;
    }

    public void setTeach_name(String teach_name) {
        this.teach_name = teach_name;
    }
}
