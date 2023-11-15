package com.example.demo.handler;

import com.example.demo.domain.Student;
import com.example.demo.model.StudentModel;
import com.example.demo.service.StudentService;
import com.example.demo.transformer.StudentTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentHandler {
    private StudentService studentService;
    private StudentTransformer studentTransformer;


    public StudentHandler(StudentService studentService, StudentTransformer studentTransformer) {
        this.studentService = studentService;
        this.studentTransformer = studentTransformer;
    }

    public List<StudentModel> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        List<StudentModel> studentModels = new ArrayList<>();
        for(Student student : students){
            studentModels.add(studentTransformer.toModel(student));
        }
        return studentModels;
    }

    public StudentModel findStudent(String name) {
        Student student = studentService.findStudent(name);
        return studentTransformer.toModel(student);
    }

    public List<StudentModel> getStudentByFees(double fees) {
        List<Student> students = studentService.getStudentByFees(fees);
        List<StudentModel> studentModels = new ArrayList<>();
        for(Student student : students){
            studentModels.add(studentTransformer.toModel(student));
        }
        return studentModels;
    }
}
