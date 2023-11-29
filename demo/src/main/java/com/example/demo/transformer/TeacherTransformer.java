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
            return new Teacher(modal.getId(),
                    new Human(modal.getHumanModel().getName(),
                            modal.getHumanModel().getFatherName(),
                            modal.getHumanModel().getCnic(),
                            modal.getHumanModel().getAge(),
                            new Address(modal.getHumanModel().getAddressModel().getHouseNumber(),
                                    modal.getHumanModel().getAddressModel().getStreetNumber(),
                                    modal.getHumanModel().getAddressModel().getCity(),
                                    modal.getHumanModel().getAddressModel().getDistrict())),
                    modal.getSalary(),
                    modal.getBookList());
        }
        return null;
    }

    public TeacherModal toModal(Teacher entity) {
        if (entity != null) {
            return new TeacherModal(entity.getId(),
                    new HumanModel(
                            entity.getHuman().getName(),
                            entity.getHuman().getFatherName(),
                            entity.getHuman().getCnic(),
                            entity.getHuman().getAge(),
                            new AddressModel(
                                    entity.getHuman().getAddress().getHouseNumber(),
                                    entity.getHuman().getAddress().getStreetNumber(),
                                    entity.getHuman().getAddress().getCity(),
                                    entity.getHuman().getAddress().getDistrict()
                            )
                    ),
                    entity.getSalary(),
                    entity.getBookList());
        }
        return null;
    }
}