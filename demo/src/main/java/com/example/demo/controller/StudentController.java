package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.handler.StudentHandler;
import com.example.demo.model.StudentModel;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentHandler studentHandler;

    @Autowired
    public StudentController(StudentHandler studentHandler) {
        this.studentHandler = studentHandler;
    }

    @PostMapping("/create")
    public String createStudent(@RequestBody StudentModel studentModel) {
        return studentHandler.createStudent(studentModel);
    }

    @GetMapping("/name")
    public List<StudentModel> getStudentByName(@RequestParam String name) {
        return studentHandler.getStudentByName(name);
    }
    @GetMapping("/records")
    public List<StudentModel>getAllStudentByNameAndFatherName
            (@RequestParam String name,@RequestParam String fatherName){
        return studentHandler.getAllStudentByNameAndFatherName(name,fatherName);
       
    }
    @GetMapping("/city")
    public List<StudentModel>getAllStudentByCity(@RequestParam String city){
        return studentHandler.getAllStudentByCity(city);
    }
    @GetMapping("/district")
    public List<StudentModel>getAllStudentByDistrict(@RequestParam String district){
        return studentHandler.getAllStudentByDistrict(district);
    }
    @GetMapping("/count")
    public long getTotalStudentCount(){
        return studentHandler.getTotalStudentCount();}
    }

