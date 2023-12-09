package com.example.demo.transformer;

import com.example.demo.domain.ClassLevel;
import com.example.demo.model.ClassLevelModel;
import org.springframework.stereotype.Component;

@Component
public class ClassLevelTransformer {

    public ClassLevel toEntity(ClassLevelModel model) {
        if (model == null) {
            return null;
        } else {
            return ClassLevel.builder().id(model.getId()).name(model.getName()).bookList(model.getBookList()).build();
        }
    }

    public ClassLevelModel toModel(ClassLevel entity) {
        if (entity == null) {
            return null;
        } else {
            return ClassLevelModel.builder().id(entity.getId()).name(entity.getName()).bookList(entity.getBookList()).build();
        }
    }
}
