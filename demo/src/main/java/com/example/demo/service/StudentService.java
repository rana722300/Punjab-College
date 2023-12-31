package com.example.demo.service;

import com.example.demo.domain.Book;
import com.example.demo.domain.ClassLevel;
import com.example.demo.domain.Student;
import com.example.demo.model.StudentCount;
import com.example.demo.model.StudentSearchCriteria;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.ClassLevelRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.StudentRepositoryImpl;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final BookRepository bookRepository;
    private final ClassLevelRepository classLevelRepository;
    private final StudentRepositoryImpl studentRepositoryImpl;

    public StudentService(StudentRepository studentRepository, BookRepository bookRepository, ClassLevelRepository classLevelRepository, StudentRepositoryImpl studentRepositoryImpl) {
        this.studentRepository = studentRepository;
        this.bookRepository = bookRepository;
        this.classLevelRepository = classLevelRepository;
        this.studentRepositoryImpl = studentRepositoryImpl;
    }

    public String createStudent(Student student) {
        boolean studentExist = studentRepository.existsByHuman_Cnic(student.getHuman().getCnic());
        if (!studentExist) {
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

    public long getTotalStudentCount() {
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

    public List<StudentCount> countStudentsInClass() {
        List<ClassLevel> classLevels = classLevelRepository.findAll();
        List<StudentCount> studentCounts = new ArrayList<>();
        for (ClassLevel classLevel : classLevels) {
            long totalCount = studentRepository.countByClassLevel_Id(classLevel.getId());
            studentCounts.add(StudentCount.builder()
                    .name(classLevel.getName())
                    .count(totalCount)
                    .build());
        }
        return studentCounts;
    }

    public List<Student> getAllStudentByFatherName(String fatherName) {
        return studentRepository.getAllByHuman_FatherName(fatherName);
    }

    public List<Student> getAllStudentByHouseNumber(String houseNumber) {
        return studentRepository.getAllByHuman_Address_HouseNumber(houseNumber);
    }

    public List<Student> getAllStudentByFees(double fees) {
        return studentRepository.getAllByFees(fees);
    }

    public Page<Student> getCustomStudent(StudentSearchCriteria studentSearchCriteria) {
        return studentRepositoryImpl.getCustomStudent(studentSearchCriteria);
    }
}