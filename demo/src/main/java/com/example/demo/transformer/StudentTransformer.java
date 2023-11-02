package com.example.demo.transformer;

import com.example.demo.domain.Student;
import com.example.demo.model.AddressModel;
import com.example.demo.model.HumanModel;
import com.example.demo.model.StudentModel;
import org.springframework.stereotype.Component;

@Component
public class StudentTransformer {
    public StudentModel toModel(Student entity) {
        if(entity == null){
            return null;
        }else{
            return new StudentModel(entity.getId(),
                    entity.getFees(),
                    new HumanModel(entity.getHuman().getName(),
                            entity.getHuman().getFatherName(),
                            entity.getHuman().getCnic(),
                            entity.getHuman().getAge(),
                            new AddressModel(entity.getHuman().getAddress().getHouseNumber(),
                                    entity.getHuman().getAddress().getStreetNumber(),
                                    entity.getHuman().getAddress().getCity(),
                                    entity.getHuman().getAddress().getDistrict())));
        }
    }
}
