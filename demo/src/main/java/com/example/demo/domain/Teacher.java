package com.example.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Document (collection = "teacher")
public class Teacher {
   @Id
   private UUID id;
   private Human human;
   private double salary;
   @DBRef
   private List<Book> bookList;

    public Teacher(UUID id, Human human, double salary, List<Book> bookList) {
        this.id = id;
        this.human = human;
        this.salary = salary;
        this.bookList = bookList;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
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
