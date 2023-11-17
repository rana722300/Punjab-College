package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.handler.StudentHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/example")
    public String cityStudent(@RequestParam String city) {
        return "City of Student is : \nStudent Address : " + city;
    }

}
