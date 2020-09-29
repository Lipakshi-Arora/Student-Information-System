package com.example.informationSystem.service;

import com.example.informationSystem.model.student;
import java.util.List;

public interface studentService {
    List<student> getAll();

    student findByStudentNumber(long studentNumber);

    student findByEmail(String email);

    List<student> findAllByOrderByGpaDesc();

    student saveOrUpdateStudent(student student);

    void deleteStudentById(long id);


    student create(String id, String name, long studentNumber, String email, List<String> courseList, float gpa);

    String create(student stu);

    void deleteAll();
}
