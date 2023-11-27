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
        return getStudentModels(students);
    }
    public List<StudentModel> getAllStudentByNameAndFatherName(String name, String fatherName) {
        List<Student> students = studentService.getAllStudentByNameAndFatherName(name, fatherName);
        return getStudentModels(students);
    }

    public List<StudentModel> getAllStudentByCity(String city) {
        List<Student> students = studentService.getAllStudentByCity(city);
        return getStudentModels(students);
    }

    public List<StudentModel> getAllStudentByDistrict(String district) {
        List<Student> students =studentService.getAllStudentByDistrict(district);
        return getStudentModels(students);
    }

    private List<StudentModel> getStudentModels(List<Student> students) {
        List<StudentModel>studentModels = new ArrayList<>();
        for (Student student : students) {
            studentModels.add(studentTransformer.toModel(student));
        }
        return studentModels;
    }
}

