package com.example.demo.transformer;

import com.example.demo.domain.Book;
import com.example.demo.model.BookModel;
import org.springframework.stereotype.Component;

@Component
public class BookTransformer {

    public Book toEntity(BookModel model) {
        if (model != null) {
            return Book.builder().id(model.getId())
                    .name(model.getName())
                    .build();
        }
        return null;
    }

    public BookModel toModel(Book entity) {
        if (entity != null) {
            return BookModel.builder().id(entity.getId())
                    .name(entity.getName())
                    .build();
        }
        return null;
    }
}
