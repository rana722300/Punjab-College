package com.example.demo.handler;

import com.example.demo.domain.Student;
import com.example.demo.service.StudentService;
import com.example.demo.transformer.StudentTransformer;
import org.springframework.stereotype.Component;

@Component
public class StudentHandler {
    private final StudentService studentService;
    private final StudentTransformer studentTransformer;


    public StudentHandler(StudentService studentService, StudentTransformer studentTransformer) {
        this.studentService = studentService;
        this.studentTransformer = studentTransformer;
    }

    public void createStudent(Student student) {
        studentService.createStudent(student);
    }
}
