package com.example.demo.service;

import com.example.demo.domain.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public String createStudent(Student student) {
        boolean studentExist = studentRepository.existsByHuman_Cnic(student.getHuman().getCnic());
        if(studentExist){
            studentRepository.save(student);
            return "Student Created Successfully.";
        }
        return "Student Al-ready Exist.";

    }

    public List<Student> getStudentByName(String name) {
        return studentRepository.getAllByHuman_Name(name);
    }

    public List<Student> getAllStudentByNameAndFatherName(String name, String fatherName) {
        return studentRepository.getAllByHuman_NameAndHuman_FatherName(name, fatherName);
    }

    public List<Student> getAllStudentByCity(String city) {
        return studentRepository.getAllByHuman_Address_City(city);
    }

    public List<Student> getAllStudentByDistrict(String district) {
        return studentRepository.getAllByHuman_Address_district(district);
    }
}
