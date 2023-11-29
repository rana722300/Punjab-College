package com.example.demo.handler;

import com.example.demo.domain.Teacher;
import com.example.demo.model.TeacherModal;
import com.example.demo.service.TeacherService;
import com.example.demo.transformer.TeacherTransformer;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TeacherHandler {
    private final TeacherService teacherService;
    private final TeacherTransformer teacherTransformer;

    public TeacherHandler(TeacherService teacherService, TeacherTransformer teacherTransformer) {
        this.teacherService = teacherService;
        this.teacherTransformer = teacherTransformer;
    }

    public String createNewTeacher(TeacherModal teacherModal) {
        boolean exist = teacherService.existsByHuman_cnic(teacherModal.getHumanModel().getCnic());
        if(!exist){
            teacherModal.setId(UUID.randomUUID());
            Teacher teacher = teacherTransformer.toEntity(teacherModal);
            teacherService.createNewRecord(teacher);
            return "Teacher Created Successfully.";
        }
        return "Please enter unique cnic.";
    }
}
