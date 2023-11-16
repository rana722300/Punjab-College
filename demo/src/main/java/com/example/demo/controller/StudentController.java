package com.example.demo.controller;

import com.example.demo.domain.Address;
import com.example.demo.domain.Student;
import com.example.demo.handler.StudentHandler;
import com.example.demo.model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private StudentHandler studentHandler;

    @Autowired
    public StudentController(StudentHandler studentHandler) {
        this.studentHandler = studentHandler;
    }

    @GetMapping("/list")
    public List<StudentModel> getAllStudents(){
        return studentHandler.getAllStudents();
    }

    @GetMapping("/find/{name}")
    public StudentModel findStudent(@PathVariable String name){
        return studentHandler.findStudent(name);
    }

    @GetMapping("/fees/{fees}")
    public List<StudentModel> getStudentByFees(@PathVariable double fees){
        return studentHandler.getStudentByFees(fees);
    }

    @PostMapping("/create")
    public String createStudent(@RequestBody Student student){
        return "Student Created Successfully. \nStudent Fees : " + student.getFees() + "\nStudent Name : " + student.getHuman().getName();
        //return student;
    }
    @GetMapping("/example")
    public String cityStudent(@RequestParam String city){
        return "City of Student is : \nStudent Address : " + city;
    }

}
