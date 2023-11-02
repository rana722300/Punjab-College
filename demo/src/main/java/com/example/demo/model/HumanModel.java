package com.example.demo.model;

public class HumanModel {
    private final String name;
    private final String fatherName;
    private final String cnic;
    private final int age;
    private final AddressModel addressModel;

    public HumanModel(String name, String fatherName, String cnic, int age, AddressModel addressModel) {
        this.name = name;
        this.fatherName = fatherName;
        this.cnic = cnic;
        this.age = age;
        this.addressModel = addressModel;
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

    public AddressModel getAddressModel() {
        return addressModel;
    }
}
