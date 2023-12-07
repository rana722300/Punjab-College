package com.example.demo.transformer;

import com.example.demo.domain.ClassLevel;
import com.example.demo.model.ClassLevelModel;
import org.springframework.stereotype.Component;

@Component
public class ClassLevelTransformer {

    public ClassLevel toEntity(ClassLevelModel model){
        if(model == null){
            return null;
        }else{
            return new ClassLevel(model.getId(), model.getName(), model.getBookList());
        }
    }

    public ClassLevelModel toModel(ClassLevel entity){
        if(entity == null){
            return null;
        }else{
            return new ClassLevelModel(entity.getId(), entity.getName(), entity.getBookList());
        }
    }
}
