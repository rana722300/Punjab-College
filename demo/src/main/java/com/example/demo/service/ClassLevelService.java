package com.example.demo.service;

import com.example.demo.domain.ClassLevel;
import com.example.demo.repository.ClassLevelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassLevelService {
    public final ClassLevelRepository classLevelRepository;

    public ClassLevelService(ClassLevelRepository classLevelRepository) {
        this.classLevelRepository = classLevelRepository;
    }

    public String createClassLevel(ClassLevel classLevel) {
        boolean classLevelExist = classLevelRepository.existsByName(classLevel.getName());
        if(classLevelExist){
            return "Class already exist.";
        }else{
            classLevelRepository.save(classLevel);
            return "Class created successfully.";
        }
    }

    public List<ClassLevel> getAll() {
        return classLevelRepository.findAll();
    }
}
