package com.example.demo.service;

import com.example.demo.domain.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createStudent(Student student) {
        student.setId(UUID.randomUUID());
        studentRepository.save(student);
    }

    public List<Student> getStudentByName(String name) {
        return studentRepository.getAllByHuman_Name(name);
    }
    public List<Student>getAllStudentByNameAndFatherName(String name, String fatherName){
        return studentRepository.getAllByHuman_NameAndHuman_FatherName(name,fatherName);
    }

    public List<Student> getAllStudentByCity(String city) {
        return studentRepository.getAllByHuman_Address_City(city);
    }

    public List<Student> getAllStudentByDistrict(String district) {
        return studentRepository.getAllByHuman_Address_district(district);
    }
}
