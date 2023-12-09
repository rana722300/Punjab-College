package com.example.demo.transformer;

import com.example.demo.domain.Student;
import com.example.demo.model.AddressModel;
import com.example.demo.model.HumanModel;
import com.example.demo.model.StudentModel;
import org.springframework.stereotype.Component;

@Component
public class StudentTransformer {
    public StudentModel toModel(Student entity) {
        if (entity == null) {
            return null;
        } else {
            return StudentModel.builder().id(entity.getId()).fees(entity.getFees()).humanModel(HumanModel.builder().name(entity.getHuman().getName()).fatherName(entity.getHuman().getFatherName()).age(entity.getHuman().getAge()).cnic(entity.getHuman().getCnic()).addressModel(AddressModel.builder().city(entity.getHuman().getAddress().getCity()).district(entity.getHuman().getAddress().getDistrict()).houseNumber(entity.getHuman().getAddress().getHouseNumber()).streetNumber(entity.getHuman().getAddress().getStreetNumber()).build()).build()).build();
        }
    }
}
