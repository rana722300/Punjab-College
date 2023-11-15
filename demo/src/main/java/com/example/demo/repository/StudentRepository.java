package com.example.demo.repository;

import com.example.demo.domain.Address;
import com.example.demo.domain.Human;
import com.example.demo.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class StudentRepository {

    public List<Student> getAllStudents() {
        List<Student> students = cetateStudentList();
        return students;
    }

    private List<Student> cetateStudentList() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(UUID.randomUUID(), 2000,
                new Human("Ali", "Umair", "31201-123456-7", 18,
                new Address("112/B", "B/1", "APE", "BWP"))));
        students.add(new Student(UUID.randomUUID(), 5000,
                new Human("Zain", "Umair", "31201-123456-7", 18,
                        new Address("112/B", "B/1", "APE", "BWP"))));
        students.add(new Student(UUID.randomUUID(), 7000,
                new Human("Qasim", "Umair", "31201-123456-7", 18,
                        new Address("112/B", "B/1", "APE", "BWP"))));
        return students;
    }

    public Student findStudent(String name) {
        List<Student> students = cetateStudentList();
        for(Student student : students){
            if(student.getHuman().getName().equals(name)){
                return student;
            }
        }
        return null;
    }

}