package com.example.demo.service;

import com.example.demo.domain.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public String createNewRecord(Book book) {
        boolean existBook = bookRepository.existsByName(book.getName());
        if(!existBook){
            bookRepository.save(book);
            return "Book Created Successfully.";
        }
        return "Book Name Already Exist.";
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
