package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    @GetMapping("/name")
    public String getStudentName(){
        return "Danish";
    }

    @GetMapping("/father-name")
    public String getFatherName(){return "Abdul Hafeez";}
}
