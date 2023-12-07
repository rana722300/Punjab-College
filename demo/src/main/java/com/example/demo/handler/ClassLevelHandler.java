package com.example.demo.handler;

import com.example.demo.domain.ClassLevel;
import com.example.demo.model.ClassLevelModel;
import com.example.demo.service.ClassLevelService;
import com.example.demo.transformer.ClassLevelTransformer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ClassLevelHandler {
    public final ClassLevelService classLevelService;
    public final ClassLevelTransformer classLevelTransformer;

    public ClassLevelHandler(ClassLevelService classLevelService, ClassLevelTransformer classLevelTransformer) {
        this.classLevelService = classLevelService;
        this.classLevelTransformer = classLevelTransformer;
    }

    public String createClassLevel(ClassLevelModel classLevelModel) {
        classLevelModel.setId(UUID.randomUUID());
        ClassLevel classLevel = classLevelTransformer.toEntity(classLevelModel);
        return classLevelService.createClassLevel(classLevel);
    }

    public List<ClassLevelModel> getAll() {
        List<ClassLevel> classLevels = classLevelService.getAll();
        List<ClassLevelModel> classLevelModels = new ArrayList<>();
        for(ClassLevel classLevel : classLevels){
            classLevelModels.add(classLevelTransformer.toModel(classLevel));
        }
        return classLevelModels;
    }
}
