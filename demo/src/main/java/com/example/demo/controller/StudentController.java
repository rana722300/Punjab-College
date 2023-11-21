package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.handler.StudentHandler;
import com.example.demo.model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentHandler studentHandler;

    @Autowired
    public StudentController(StudentHandler studentHandler) {
        this.studentHandler = studentHandler;
    }

    @PostMapping("/create")
    public String createStudent(@RequestBody Student student) {
        studentHandler.createStudent(student);
        return "Student Created Successfully. \nStudent Fees : " + student.getFees() + "\nStudent Name : " + student.getHuman().getName();
    }

    @GetMapping("/name")
    public List<StudentModel> getStudentByName(@RequestParam String name) {
        return studentHandler.getStudentByName(name);
    }

}
