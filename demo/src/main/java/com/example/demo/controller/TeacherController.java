package com.example.demo.controller;

import com.example.demo.handler.TeacherHandler;
import com.example.demo.model.TeacherModal;
import com.example.demo.model.TeacherSearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherHandler teacherHandler;

    @Autowired
    public TeacherController(TeacherHandler teacherHandler) {
        this.teacherHandler = teacherHandler;
    }


    @PostMapping
    public String createNewRecord(@RequestBody TeacherModal teacherModal){
        return teacherHandler.createNewTeacher(teacherModal);
    }

    @GetMapping
    public List<TeacherModal> getAllTeacher(){
        return teacherHandler.getAllTeacher();
    }

    @GetMapping("/name/fatherName")
    public  List<TeacherModal> getAllTeacherByNameAndFatherName
            (@RequestParam String name, @RequestParam String fatherName){
        return teacherHandler.findAllTeacherByNameAndFatherName(name,fatherName);
    }
    @GetMapping("/custom/salary")
    public Page<TeacherModal> getCustomTeacher(@RequestBody TeacherSearchCriteria teacherSearchCriteria) {
        return teacherHandler.getCustomTeacher(teacherSearchCriteria);
    }
}
