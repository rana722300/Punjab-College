package com.example.demo.service;

import com.example.demo.domain.Teacher;
import com.example.demo.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public void createNewRecord(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public boolean existsByHuman_cnic(String cnic) {
        return teacherRepository.existsByHuman_cnic(cnic);
    }

    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }

    public List<Teacher> findAllTeacherByNameAndFatherName(String name, String fatherName) {
        return teacherRepository.findAllByHuman_NameAndHuman_FatherName(name, fatherName);
    }
}
