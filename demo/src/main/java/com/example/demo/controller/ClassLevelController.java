package com.example.demo.controller;

import com.example.demo.handler.ClassLevelHandler;
import com.example.demo.model.ClassLevelModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class-level")
public class ClassLevelController {
    public final ClassLevelHandler classLevelHandler;

    @Autowired
    public ClassLevelController(ClassLevelHandler classLevelHandler) {
        this.classLevelHandler = classLevelHandler;
    }

    @PostMapping
    public String createClassLevel(@RequestBody ClassLevelModel classLevelModel){
        return classLevelHandler.createClassLevel(classLevelModel);
    }

    @GetMapping
    public List<ClassLevelModel> getAll(){
        return classLevelHandler.getAll();
    }
}
