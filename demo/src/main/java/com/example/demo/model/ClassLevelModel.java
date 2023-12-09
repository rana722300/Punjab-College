package com.example.demo.model;

import com.example.demo.domain.Book;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class ClassLevelModel {
    private UUID id;
    private String name;
    private List<Book> bookList;

}
