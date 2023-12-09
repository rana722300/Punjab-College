package com.example.demo.domain;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Address {
    private String houseNumber;
    private String streetNumber;
    private String city;
    private String district;

}
