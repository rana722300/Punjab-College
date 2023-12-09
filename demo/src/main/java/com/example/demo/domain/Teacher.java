package com.example.demo.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@Document(collection = "teacher")
public class Teacher {
    @Id
    private UUID id;
    private Human human;
    private double salary;
    @DBRef
    private List<Book> bookList;

}
