package com.itlike_resvalue.dao;

import com.itlike_resvalue.domain.Teach;

import java.util.List;

public interface TeachMapper {
    List<Teach> getAllTeach();
    List<Teach> getTeachByStuId(Integer id);
    void addTeacher(Teach teach);
}
