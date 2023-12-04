package com.example.demo.repository;

import com.example.demo.domain.Book;
import com.example.demo.domain.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TeacherRepository extends MongoRepository<Teacher, UUID> {
    boolean existsByHuman_cnic(String cnic);

    List<Teacher> findAllByHuman_NameAndHuman_FatherName(String name, String fatherName);

    List<Teacher> findAllByHuman_Cnic(String cnic);

    List<Teacher> findAllByHuman_Address_City(String city);


}
