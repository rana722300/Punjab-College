package com.example.demo.repository;

import com.example.demo.domain.ClassLevel;
import com.example.demo.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepository extends MongoRepository<Student, UUID> {
    @Query(fields = "{'human.fatherName':1")
    List<Student> getAllByHuman_Name(String name);

    List<Student> getAllByHuman_NameAndHuman_FatherName(String name, String fatherName);

    @Query(fields = "{'fees':1, 'human.name':1, 'human.age':1, 'human.address.district':1}")
    List<Student> getAllByHuman_Address_City(String city);

    List<Student> getAllByHuman_Address_district(String district);

    boolean existsByHuman_Cnic(String cnic);

    long countByClassLevel_Id(UUID id);

    List<Student> getAllByClassLevelIn(List<UUID> ids);
    @Query(fields = "{'human.address.houseNumber':1,'human.age':1,'fees':1}")
    List<Student> getAllByHuman_FatherName(String fatherName);
    @Query(fields = "{'human.address.streetNumber':1,'human.age':1,'fees':1}")
    List<Student> getAllByHuman_Address_HouseNumber(String houseNumber);
    @Query(fields = "{'human.age':1, 'fees':1, 'human.fatherName':1, 'human.address.houseNumber':1}")
    List<Student> getAllByFees(double fees);

}
