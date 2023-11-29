package com.example.demo.controller;

import com.example.demo.handler.TeacherHandler;
import com.example.demo.model.TeacherModal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
