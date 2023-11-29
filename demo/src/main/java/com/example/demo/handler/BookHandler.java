package com.example.demo.handler;

import com.example.demo.domain.Book;
import com.example.demo.model.BookModel;
import com.example.demo.service.BookService;
import com.example.demo.transformer.BookTransformer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class BookHandler {
    private final BookService bookService;
    private final BookTransformer bookTransformer;

    public BookHandler(BookService bookService, BookTransformer bookTransformer) {
        this.bookService = bookService;
        this.bookTransformer = bookTransformer;
    }

    public String createNewRecord(String name) {
        Book book = new Book(UUID.randomUUID(), name);
        return bookService.createNewRecord(book);
    }

    public List<BookModel> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        List<BookModel> bookModels = new ArrayList<>();
        for(Book book : books){
            bookModels.add(bookTransformer.toModel(book));
        }
        return bookModels;
    }
}
