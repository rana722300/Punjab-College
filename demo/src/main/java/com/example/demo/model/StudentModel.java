package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class StudentModel {
    private UUID id;
    private double fees;
    private HumanModel humanModel;
    private ClassLevelModel classLevelModel;
}
