package com.example.demo.model;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class TeacherSearchCriteria {
    private int salary;
    private int pageSize;
    private int pageNumber;
}
