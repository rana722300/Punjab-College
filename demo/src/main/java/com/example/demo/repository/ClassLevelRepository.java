package com.example.demo.repository;


import com.example.demo.domain.ClassLevel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClassLevelRepository extends MongoRepository<ClassLevel, UUID> {
    boolean existsByName(String name);
}
