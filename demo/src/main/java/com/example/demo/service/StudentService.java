package com.example.demo.service;

import com.example.demo.domain.Book;
import com.example.demo.domain.ClassLevel;
import com.example.demo.domain.Student;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.ClassLevelRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final BookRepository bookRepository;
    private final ClassLevelRepository classLevelRepository;

    public StudentService(StudentRepository studentRepository, BookRepository bookRepository, ClassLevelRepository classLevelRepository) {
        this.studentRepository = studentRepository;
        this.bookRepository = bookRepository;
        this.classLevelRepository = classLevelRepository;
    }

    public String createStudent(Student student) {
        boolean studentExist = studentRepository.existsByHuman_Cnic(student.getHuman().getCnic());
        if(!studentExist){
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
    public long getTotalStudentCount(){
        return studentRepository.count();
    }

    public List<Student> getTotalStudentInSpecificBook(String name) {
        Book book = bookRepository.findByName(name);
        List<ClassLevel> classLevels = classLevelRepository.findByBookList(book.getId());
        List<UUID> classLevelIds = classLevels.stream()
                .map(ClassLevel::getId)
                .collect(Collectors.toList());

        return studentRepository.getAllByClassLevelIn(classLevelIds);
    }
}
