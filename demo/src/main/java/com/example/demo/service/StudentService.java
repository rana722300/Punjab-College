package com.example.demo.service;

import com.example.demo.domain.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public Student findStudent(String name) {
        return studentRepository.findStudent(name);
    }

    public List<Student> getStudentByFees(double fees) {
        List<Student> students = studentRepository.getAllStudents();
        List<Student> filterStudents = new ArrayList<>();
        for (Student student : students){
            if (student.getFees() >= fees){
                filterStudents.add(student);

            }
        }
        return filterStudents;
    }
}
