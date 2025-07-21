package com.library.library_api.controller;

import com.library.library_api.model.entity.BookEntity;
import com.library.library_api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {


    @Autowired
    BookRepository bookRepository;

     @GetMapping
     public List<BookEntity> getBooks() {
         return bookRepository.findAll();
    }

    @PostMapping
    public BookEntity postBook(@RequestBody BookEntity book) {
        return bookRepository.save(book);
    }
}

