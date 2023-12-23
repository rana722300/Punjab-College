package com.example.demo.repository;

import com.example.demo.domain.ClassLevel;
import com.example.demo.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepository extends MongoRepository<Student, UUID> {
    List<Student> getAllByHuman_Name(String name);

    List<Student> getAllByHuman_NameAndHuman_FatherName(String name, String fatherName);

    List<Student> getAllByHuman_Address_City(String city);

    List<Student> getAllByHuman_Address_district(String district);

    boolean existsByHuman_Cnic(String cnic);

    long countByClassLevel_Id(UUID id);

    List<Student> getAllByClassLevelIn(List<UUID> ids);


}
