package com.example.demo.handler;

import com.example.demo.domain.Student;
import com.example.demo.model.StudentCount;
import com.example.demo.model.StudentModel;
import com.example.demo.service.StudentService;
import com.example.demo.transformer.StudentTransformer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class StudentHandler {
    private final StudentService studentService;
    private final StudentTransformer studentTransformer;


    public StudentHandler(StudentService studentService, StudentTransformer studentTransformer) {
        this.studentService = studentService;
        this.studentTransformer = studentTransformer;
    }

    public String createStudent(StudentModel studentModel) {
        studentModel.setId(UUID.randomUUID());
        Student student = studentTransformer.toEntity(studentModel);
        return studentService.createStudent(student);
    }

    public List<StudentModel> getStudentByName(String name) {
        List<Student> students = studentService.getStudentByName(name);
        return getStudentModels(students);
    }

    public List<StudentModel> getAllStudentByNameAndFatherName(String name, String fatherName) {
        List<Student> students = studentService.getAllStudentByNameAndFatherName(name, fatherName);
        return getStudentModels(students);
    }

    public List<Student> getAllStudentByCity(String city) {
//        List<Student> students =
        return studentService.getAllStudentByCity(city);
//        return getStudentModels(students);
    }

    public List<StudentModel> getAllStudentByDistrict(String district) {
        List<Student> students = studentService.getAllStudentByDistrict(district);
        return getStudentModels(students);
    }

    private List<StudentModel> getStudentModels(List<Student> students) {
        List<StudentModel> studentModels = new ArrayList<>();
        for (Student student : students) {
            studentModels.add(studentTransformer.toModel(student));
        }
        return studentModels;
    }

    public long getTotalStudentCount() {
        return studentService.getTotalStudentCount();
    }

    public List<StudentModel> getTotalStudentInSpecificBook(String name) {
        List<Student> students = studentService.getTotalStudentInSpecificBook(name);
        List<StudentModel> studentModels = new ArrayList<>();
        for (Student student : students) {
            studentModels.add(studentTransformer.toModel(student));
        }
        return studentModels;
    }

    public List<StudentCount> countStudentsInClass() {
        return studentService.countStudentsInClass();
    }

    public List<Student> getAllStudentByFatherName(String fatherName) {
        return studentService.getAllStudentByFatherName(fatherName);
    }

    public List<Student> getAllStudentByHouseNumber(String houseNumber) {
        return studentService.getAllStudentByHouseNumber(houseNumber);
    }

    public List<Student> getAllStudentByFees(double fees) {
        return studentService.getAllStudentByFees(fees);
    }
}


