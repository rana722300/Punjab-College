package com.example.demo.handler;

import com.example.demo.domain.Teacher;
import com.example.demo.model.TeacherModal;
import com.example.demo.service.TeacherService;
import com.example.demo.transformer.TeacherTransformer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
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

    public List<TeacherModal> getAllTeacher() {
        List<Teacher> teachers = teacherService.getAllTeacher();
        List<TeacherModal> teacherModals = new ArrayList<>();
        for(Teacher teacher : teachers){
            teacherModals.add(teacherTransformer.toModal(teacher));
        }
        return teacherModals;
    }

    public List<TeacherModal> findAllTeacherByNameAndFatherName(String name, String fatherName) {
        List<Teacher> teachers =teacherService.findAllTeacherByNameAndFatherName(name,fatherName);
        List<TeacherModal> teacherModals = new ArrayList<>();
        for (Teacher teacher: teachers){
            teacherModals.add(teacherTransformer.toModal(teacher));
        }
        return teacherModals;
    }
}
