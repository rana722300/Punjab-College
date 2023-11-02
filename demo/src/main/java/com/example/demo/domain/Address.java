package com.example.demo.domain;

public class Address {
    private String houseNumber;
    private String streetNumber;
    private String city;
    private String district;

    public Address(String houseNumber, String streetNumber, String city, String district) {
        this.houseNumber = houseNumber;
        this.streetNumber = streetNumber;
        this.city = city;
        this.district = district;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }
}
