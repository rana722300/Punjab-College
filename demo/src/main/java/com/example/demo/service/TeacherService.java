package com.example.demo.service;

import com.example.demo.domain.Teacher;
import com.example.demo.model.TeacherSearchCriteria;
import com.example.demo.repository.TeacherRepository;
import com.example.demo.repository.TeacherRepositoryImpl;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherRepositoryImpl teacherRepositoryImpl;

    public TeacherService(TeacherRepository teacherRepository, TeacherRepositoryImpl teacherRepositoryImpl) {
        this.teacherRepository = teacherRepository;
        this.teacherRepositoryImpl = teacherRepositoryImpl;

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

    public Page<Teacher> getCustomTeacher(TeacherSearchCriteria teacherSearchCriteria) {
        return teacherRepositoryImpl.getCustomTeacher(teacherSearchCriteria);
    }
}
