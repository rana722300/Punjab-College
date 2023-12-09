package com.example.demo.handler;

import com.example.demo.domain.ClassLevel;
import com.example.demo.model.ClassLevelModel;
import com.example.demo.service.ClassLevelService;
import com.example.demo.transformer.ClassLevelTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ClassLevelHandler {
    public final ClassLevelService classLevelService;
    public final ClassLevelTransformer classLevelTransformer;
    
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


    public void createClass(List<String> classNames) {
        classLevelService.createClass(classNames);
    }
}
