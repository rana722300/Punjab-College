package com.example.demo.repository;

import com.example.demo.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookRepository extends MongoRepository<Book, UUID> {
    boolean existsByName(String name);

    Book findByName(String name);
}
