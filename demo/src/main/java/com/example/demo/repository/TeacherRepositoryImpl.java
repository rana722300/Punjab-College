package com.example.demo.repository;

import com.example.demo.domain.Student;
import com.example.demo.domain.Teacher;
import com.example.demo.model.StudentSearchCriteria;
import com.example.demo.model.TeacherSearchCriteria;
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
public class TeacherRepositoryImpl {
    private final MongoTemplate mongoTemplate;


    public Page<Teacher> getCustomTeacher(TeacherSearchCriteria teacherSearchCriteria) {
        Query query = new Query();
        Sort sort = getSortByCriteria(teacherSearchCriteria);
        Pageable pageable = PageRequest.of(teacherSearchCriteria.getPageNumber(), teacherSearchCriteria.getPageSize(), sort);
        List<Criteria> criteria = new ArrayList<>();
        criteria.add(Criteria.where("salary").is(teacherSearchCriteria.getSalary()));
        query.addCriteria(new Criteria().andOperator(criteria));
        query.collation(Collation.of(Locale.ENGLISH))
                .with(pageable)
                .skip((long) pageable.getPageSize() * pageable.getPageNumber())
                .limit(pageable.getPageSize());
        List<Teacher> teachers = mongoTemplate.find(query,Teacher.class, "teacher");
        long count = mongoTemplate.count(query.skip(-1), Teacher.class);
        return new PageImpl<>(teachers,pageable,count);
    }
    private Sort getSortByCriteria(TeacherSearchCriteria teacherSearchCriteria){
        return Sort.by(Sort.Direction.ASC,"salary");
    }
    }
