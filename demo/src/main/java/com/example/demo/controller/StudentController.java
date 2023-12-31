package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.handler.StudentHandler;
import com.example.demo.model.StudentCount;
import com.example.demo.model.StudentModel;
import com.example.demo.model.StudentSearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentHandler studentHandler;

    @Autowired
    public StudentController(StudentHandler studentHandler) {
        this.studentHandler = studentHandler;
    }

    @PostMapping("/create")
    public String createStudent(@RequestBody StudentModel studentModel) {
        return studentHandler.createStudent(studentModel);
    }

    @GetMapping("/name")
    public List<StudentModel> getStudentByName(@RequestParam String name) {
        return studentHandler.getStudentByName(name);
    }

    @GetMapping("/records")
    public List<StudentModel> getAllStudentByNameAndFatherName
            (@RequestParam String name, @RequestParam String fatherName) {
        return studentHandler.getAllStudentByNameAndFatherName(name, fatherName);

    }

    @GetMapping("/city")
    public List<Student> getAllStudentByCity(@RequestParam String city) {
        return studentHandler.getAllStudentByCity(city);
    }

    @GetMapping("/district")
    public List<StudentModel> getAllStudentByDistrict(@RequestParam String district) {
        return studentHandler.getAllStudentByDistrict(district);
    }

    @GetMapping("/count")
    public long getTotalStudentCount() {
        return studentHandler.getTotalStudentCount();
    }

    @GetMapping("/book/{name}")
    public List<StudentModel> getTotalStudentInSpecificBook(@PathVariable String name) {
        return studentHandler.getTotalStudentInSpecificBook(name);
    }

    @GetMapping("/count-by-class")
    public List<StudentCount> countStudentsInClass() {
        return studentHandler.countStudentsInClass();
    }
    @GetMapping("/fatherName")
    public List<Student> getAllStudentByFatherName(@RequestParam String fatherName) {
        return studentHandler.getAllStudentByFatherName(fatherName);
    }
    @GetMapping("/houseNumber")
    public List<Student> getAllStudentByHouseNumber(@RequestParam String houseNumber){
        return studentHandler.getAllStudentByHouseNumber(houseNumber);
    }

      @GetMapping("/fees")
    public List<Student> getAllStudentByFees(@RequestParam double fees){
      return studentHandler.getAllStudentByFees(fees);
    }

    @GetMapping("/custom/fees")
    public Page<StudentModel> getCustomStudent(@RequestBody StudentSearchCriteria studentSearchCriteria){
        return studentHandler.getCustomStudent(studentSearchCriteria);
    }
}


