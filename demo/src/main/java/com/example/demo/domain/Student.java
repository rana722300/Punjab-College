package com.example.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "student")
public class Student {
    @Id
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

    public void setId(UUID id) {
        this.id = id;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public void setHuman(Human human) {
        this.human = human;
    }
}
