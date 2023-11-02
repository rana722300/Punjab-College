package com.example.demo.domain;

import java.util.UUID;


public class Student {
    private UUID id;
    private double fees;
    private Human human;

    public Student(UUID id, double fees, Human human) {
        this.id = id;
        this.fees = fees;
        this.human = human;
    }

    public UUID getId() {
        return id;
    }

    public double getFees() {
        return fees;
    }

    public Human getHuman() {
        return human;
    }
}
