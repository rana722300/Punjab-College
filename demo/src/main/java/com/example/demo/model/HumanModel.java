package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HumanModel {
    private final String name;
    private final String fatherName;
    private final String cnic;
    private final int age;
    private final AddressModel addressModel;

}
