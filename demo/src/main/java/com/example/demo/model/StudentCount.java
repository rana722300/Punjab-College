package com.example.demo.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@Builder
public class StudentCount {
    private String name;
    private long count;
}
