package com.example.demo.repository;

import com.example.demo.domain.Student;
import com.example.demo.model.StudentSearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Collation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RequiredArgsConstructor
public class StudentRepositoryImpl {
    private final MongoTemplate mongoTemplate;


    public Page<Student> getCustomStudent(StudentSearchCriteria studentSearchCriteria) {
        Query query = new Query();
        Sort sort = getSortByCriteria(studentSearchCriteria);
        Pageable pageable = PageRequest.of(studentSearchCriteria.getPageNumber(), studentSearchCriteria.getPageSize(), sort);
        List<Criteria> criteria = new ArrayList<>();
        criteria.add(Criteria.where("fees").is(studentSearchCriteria.getFees()));
        query.addCriteria(new Criteria().andOperator(criteria));
        query.collation(Collation.of(Locale.ENGLISH))
                .with(pageable)
                .skip((long) pageable.getPageSize() * pageable.getPageNumber())
                .limit(pageable.getPageSize());
        List<Student> students = mongoTemplate.find(query, Student.class, "student");
        long count = mongoTemplate.count(query.skip(-1), Student.class);
        return new PageImpl<>(students, pageable, count);
    }

    private Sort getSortByCriteria(StudentSearchCriteria studentSearchCriteria) {
        return Sort.by(Sort.Direction.ASC, "fees");
    }
}
