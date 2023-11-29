package com.example.demo.model;

import com.example.demo.domain.Book;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;
import java.util.UUID;

public class TeacherModal {
    private UUID id;
    private HumanModel humanModel;
    private double salary;
    private List<Book> bookList;

    public TeacherModal(UUID id, HumanModel humanModel, double salary, List<Book> bookList) {
        this.id = id;
        this.humanModel = humanModel;
        this.salary = salary;
        this.bookList = bookList;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public HumanModel getHumanModel() {
        return humanModel;
    }

    public void setHumanModel(HumanModel humanModel) {
        this.humanModel = humanModel;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
