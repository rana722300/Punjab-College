package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class BookModel {
    private UUID id;
    private String name;

}
