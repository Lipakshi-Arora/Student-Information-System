package com.example.informationSystem.controller;

import com.example.informationSystem.model.student;
import com.example.informationSystem.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class studentController
{
    @Autowired
    private studentService StudentService;

    @RequestMapping("/students/postData")
    public String create(@RequestParam String id, @RequestParam String name, @RequestParam long studentNumber,@RequestParam String email,
                         @RequestParam List<String> courseList,@RequestParam float gpa)
    {
        student s=StudentService.create(id,name,studentNumber,email,courseList,gpa);
        return s.toString();
    }
    @RequestMapping(method= RequestMethod.POST, value="/students/postData")
    public String create(@RequestBody student stu)
    {
        StudentService.create(stu);
        return ("Hi, you have been registered!");
    }

    @GetMapping(value = "/students/getData")
    public List<student> getAllStudents() {
        return StudentService.getAll();
    }

    @GetMapping(value = "/students/byStudentNumber/{studentNumber}")
    public student getStudentByStudentNumber(@PathVariable("studentNumber") Long studentNumber)
    {
        return StudentService.findByStudentNumber(studentNumber);
    }

    @GetMapping(value = "/students/byEmail/{email}")
    public student getStudentByEmail(@PathVariable("email") String email)
    {
        return StudentService.findByEmail(email);
    }

    @GetMapping(value = "/students/orderByGpa")
    public List<student> findAllByOrderByGpaDesc() {
        return StudentService.findAllByOrderByGpaDesc();
    }


    @DeleteMapping(value = "/students/delete/{studentNumber}")
    public void deleteStudentByStudentNumber(@PathVariable Long studentNumber) {
        StudentService.deleteStudentById(studentNumber);
    }

    @DeleteMapping(value = "/students/deleteAll")
    public String deleteAll()
    {
        StudentService.deleteAll();
        return "Deleted All Records!";
    }

}
