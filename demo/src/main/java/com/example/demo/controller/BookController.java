package com.example.demo.controller;

import com.example.demo.handler.BookHandler;
import com.example.demo.model.BookModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookHandler bookHandler;

    @Autowired
    public BookController(BookHandler bookHandler) {
        this.bookHandler = bookHandler;
    }

    @PostMapping
    public String createNewRecord(@RequestParam String name){
        return bookHandler.createNewRecord(name);
    }

    @GetMapping
    public List<BookModel> getAllBooks(){
        return bookHandler.getAllBooks();
    }
}
