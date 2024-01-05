package com.example.demo.model;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class StudentSearchCriteria {
    private double fees;
    private int pageSize;
    private int pageNumber;
}
