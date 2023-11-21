package com.example.demo.handler;

import com.example.demo.domain.Student;
import com.example.demo.model.StudentModel;
import com.example.demo.service.StudentService;
import com.example.demo.transformer.StudentTransformer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public List<StudentModel> getStudentByName(String name) {
        List<Student> students = studentService.getStudentByName(name);
        List<StudentModel> studentModels = new ArrayList<>();
        for(Student student : students){
            studentModels.add(studentTransformer.toModel(student));
        }
        return studentModels;
    }
}
