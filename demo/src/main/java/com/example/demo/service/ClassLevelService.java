package com.example.demo.service;

import com.example.demo.domain.Book;
import com.example.demo.domain.ClassLevel;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.ClassLevelRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ClassLevelService {
    public final ClassLevelRepository classLevelRepository;
    public final BookRepository bookRepository;

    public ClassLevelService(ClassLevelRepository classLevelRepository, BookRepository bookRepository) {
        this.classLevelRepository = classLevelRepository;
        this.bookRepository = bookRepository;
    }

    public String createClassLevel(ClassLevel classLevel) {
        boolean classLevelExist = classLevelRepository.existsByName(classLevel.getName());
        if (classLevelExist) {
            return "Class already exist.";
        } else {
            classLevelRepository.save(classLevel);
            return "Class created successfully.";
        }
    }

    public List<ClassLevel> getAll() {
        return classLevelRepository.findAll();
    }


    public void createClass(List<String> classNames) {
        List<Book> bookList = bookRepository.findAll();
        List<ClassLevel> classLevels = new ArrayList<>();
        int index = 0;

        for (String className : classNames) {
            List<Book> books = new ArrayList<>();
            for (Book book : bookList) {
                books.add(bookList.get(index));
                index++;
                if (index % 3 == 0) {
                    break;
                }
            }
            classLevels.add(ClassLevel.builder().id(UUID.randomUUID()).name(className).bookList(books).build());
        }
        classLevelRepository.saveAll(classLevels);
    }
}
