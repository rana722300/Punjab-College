package com.example.demo.model;

import com.example.demo.domain.Book;

import java.util.List;
import java.util.UUID;

public class ClassLevelModel {
    private UUID id;
    private String name;
    private List<Book> bookList;

    public ClassLevelModel(UUID id, String name, List<Book> bookList) {
        this.id = id;
        this.name = name;
        this.bookList = bookList;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
