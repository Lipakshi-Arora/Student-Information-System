package com.example.informationSystem.repository;

import com.example.informationSystem.model.student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface studentRepository extends MongoRepository<student, String>
{
    student findByStudentNumber(long studentNumber);//find by email or id
    student findByEmail(String email);
    List<student> findAllByOrderByGpaDesc();//store acc to gpa
}
