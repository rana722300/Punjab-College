package com.example.demo.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Human {
    private String name;
    private String fatherName;
    private String cnic;
    private int age;
    private Address address;

}
