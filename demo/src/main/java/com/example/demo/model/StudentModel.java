package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class StudentModel {
    private final UUID id;
    private final double fees;
    private final HumanModel humanModel;

}
