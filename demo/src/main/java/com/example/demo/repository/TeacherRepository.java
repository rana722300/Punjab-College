package com.example.demo.repository;

import com.example.demo.domain.Book;
import com.example.demo.domain.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TeacherRepository extends MongoRepository<Teacher, UUID> {
    boolean existsByHuman_cnic(String cnic);
}
