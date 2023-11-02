package com.example.demo.domain;

public class Human {
    private String name;
    private String fatherName;
    private String cnic;
    private int age;
    private Address address;

    public Human(String name, String fatherName, String cnic, int age, Address address) {
        this.name = name;
        this.fatherName = fatherName;
        this.cnic = cnic;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getCnic() {
        return cnic;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }
}
