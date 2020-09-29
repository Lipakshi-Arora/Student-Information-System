package com.example.informationSystem.service.impl;

import com.example.informationSystem.model.student;
import com.example.informationSystem.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.informationSystem.repository.studentRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class studentServiceImpl implements studentService
{

    @Autowired
    private studentRepository StudentRepository;

    @Override
    public List<student> getAll() {
        return StudentRepository.findAll();
    }

    @Override
    public student findByStudentNumber(long studentNumber) {
        return StudentRepository.findByStudentNumber(studentNumber);
    }

    @Override
    public student findByEmail(String email) {
        return StudentRepository.findByEmail(email);
    }

    @Override
    public List<student> findAllByOrderByGpaDesc() {
        return StudentRepository.findAllByOrderByGpaDesc();
    }

    @Override
    public student saveOrUpdateStudent(student student) {
        return StudentRepository.save(student);
    }

    @Override
    public void deleteStudentById(long id) {
        student s=StudentRepository.findByStudentNumber(id);
        StudentRepository.delete(s);
        //StudentRepository.deleteById(id);
    }

    @Override
    public student create(String id, String name, long studentNumber, String email, List<String> courseList, float gpa) {
        return StudentRepository.save(new student(id,name,studentNumber,email,courseList,gpa));
    }

    @Override
    public String create(student stu) {
        StudentRepository.save(stu);
        return ("hi! u r registered!");

    }

    @Override
    public void deleteAll() {
        StudentRepository.deleteAll();
    }
}
