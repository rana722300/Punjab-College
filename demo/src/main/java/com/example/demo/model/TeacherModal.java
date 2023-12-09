package com.example.demo.model;

import com.example.demo.domain.Book;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Builder
@Data
public class TeacherModal {
    private UUID id;
    private HumanModel humanModel;
    private double salary;
    private List<Book> bookList;

}
