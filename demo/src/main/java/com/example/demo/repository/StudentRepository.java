package com.example.demo.repository;

import com.example.demo.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface StudentRepository extends MongoRepository<Student, UUID> {

}
