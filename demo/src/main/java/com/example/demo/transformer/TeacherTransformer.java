package com.example.demo.transformer;

import com.example.demo.domain.Address;
import com.example.demo.domain.Human;
import com.example.demo.domain.Teacher;
import com.example.demo.model.AddressModel;
import com.example.demo.model.HumanModel;
import com.example.demo.model.TeacherModal;
import org.springframework.stereotype.Component;

@Component
public class TeacherTransformer {
    public Teacher toEntity(TeacherModal modal) {
        if (modal != null) {
            return Teacher.builder().human(Human.builder().name(modal.getHumanModel().getName()).fatherName(modal.getHumanModel().getFatherName()).cnic(modal.getHumanModel().getCnic()).age(modal.getHumanModel().getAge()).address(Address.builder().city(modal.getHumanModel().getAddressModel().getCity()).district(modal.getHumanModel().getAddressModel().getDistrict()).houseNumber(modal.getHumanModel().getAddressModel().getHouseNumber()).streetNumber(modal.getHumanModel().getAddressModel().getStreetNumber()).build()).build()).bookList(modal.getBookList()).salary(modal.getSalary()).build();
        }
        return null;
    }

    public static TeacherModal toModal(Teacher entity) {
        if (entity != null) {
            return TeacherModal.builder().humanModel(HumanModel.builder().name(entity.getHuman().getName()).fatherName(entity.getHuman().getFatherName()).age(entity.getHuman().getAge()).cnic(entity.getHuman().getCnic()).addressModel(AddressModel.builder().streetNumber(entity.getHuman().getAddress().getStreetNumber()).houseNumber(entity.getHuman().getAddress().getHouseNumber()).district(entity.getHuman().getAddress().getDistrict()).city(entity.getHuman().getAddress().getCity()).build()).build()).bookList(entity.getBookList()).salary(entity.getSalary()).build();
        }
        return null;
    }
}