package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AddressModel {
    private String houseNumber;
    private String streetNumber;
    private String city;
    private String district;

}
