package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeacherCount {
    private String name;
    private long count;
}
