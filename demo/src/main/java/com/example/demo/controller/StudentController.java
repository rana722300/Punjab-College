package com.example.demo.controller;

import com.example.demo.handler.StudentHandler;
import com.example.demo.model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/students")
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
}
