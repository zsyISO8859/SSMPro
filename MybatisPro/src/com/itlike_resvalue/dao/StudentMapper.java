package com.itlike_resvalue.dao;

import com.itlike_resvalue.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    List<Student> getAllStudent();
    Student getStudentWithId(Integer id);
    void addStudent(Student student);
    void addRelaWithTeach(@Param("stu_id") Integer stu_id, @Param("teach_id") Integer teach_id);
}
