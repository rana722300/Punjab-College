package com.example.demo.transformer;

import com.example.demo.domain.Book;
import com.example.demo.model.BookModel;
import org.springframework.stereotype.Component;

@Component
public class BookTransformer {

    public Book toEntity(BookModel model){
        if(model != null){
            return new Book(model.getId(), model.getName());
        }
        return null;
    }

    public BookModel toModel(Book entity){
        if(entity != null){
            return new BookModel(entity.getId(), entity.getName());
        }
        return null;
    }
}
