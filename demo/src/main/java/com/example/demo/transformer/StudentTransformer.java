package com.example.demo.transformer;

import com.example.demo.domain.Address;
import com.example.demo.domain.ClassLevel;
import com.example.demo.domain.Human;
import com.example.demo.domain.Student;
import com.example.demo.model.AddressModel;
import com.example.demo.model.ClassLevelModel;
import com.example.demo.model.HumanModel;
import com.example.demo.model.StudentModel;
import org.springframework.stereotype.Component;

@Component
public class StudentTransformer {

    public StudentModel toModel(Student entity) {
        if (entity == null) {
            return null;
        } else {
            return StudentModel.builder()
                    .id(entity.getId())
                    .fees(entity.getFees())
                    .humanModel(HumanModel.builder()
                            .name(entity.getHuman().getName())
                            .fatherName(entity.getHuman().getFatherName())
                            .age(entity.getHuman().getAge())
                            .cnic(entity.getHuman().getCnic())
                            .addressModel(AddressModel.builder()
                                    .city(entity.getHuman().getAddress().getCity())
                                    .district(entity.getHuman().getAddress().getDistrict())
                                    .houseNumber(entity.getHuman().getAddress().getHouseNumber())
                                    .streetNumber(entity.getHuman().getAddress().getStreetNumber())
                                    .build())
                            .build())
                    .classLevelModel(ClassLevelModel.builder()
                            .id(entity.getClassLevel().getId())
                            .name(entity.getClassLevel().getName())
                            .bookList(entity.getClassLevel().getBookList())
                            .build())
                    .build();
        }
    }

    public Student toEntity(StudentModel model){
        if(model == null){
            return null;
        }else{
            return Student.builder()
                    .id(model.getId())
                    .fees(model.getFees())
                    .human(Human.builder()
                            .name(model.getHumanModel().getName())
                            .fatherName(model.getHumanModel().getFatherName())
                            .age(model.getHumanModel().getAge())
                            .cnic(model.getHumanModel().getCnic())
                            .address(Address.builder()
                                    .city(model.getHumanModel().getAddressModel().getCity())
                                    .district(model.getHumanModel().getAddressModel().getDistrict())
                                    .streetNumber(model.getHumanModel().getAddressModel().getStreetNumber())
                                    .houseNumber(model.getHumanModel().getAddressModel().getHouseNumber())
                                    .build())
                            .build())
                    .classLevel(ClassLevel.builder()
                            .id(model.getClassLevelModel().getId())
                            .name(model.getClassLevelModel().getName())
                            .bookList(model.getClassLevelModel().getBookList())
                            .build())
                    .build();
        }
    }
}
