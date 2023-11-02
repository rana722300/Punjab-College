package com.example.demo.model;

import java.util.UUID;

public class StudentModel {
    private final UUID id;
    private final double fees;
    private final HumanModel humanModel;

    public StudentModel(UUID id, double fees, HumanModel humanModel) {
        this.id = id;
        this.fees = fees;
        this.humanModel = humanModel;
    }

    public UUID getId() {
        return id;
    }

    public double getFees() {
        return fees;
    }

    public HumanModel getHumanModel() {
        return humanModel;
    }
}
