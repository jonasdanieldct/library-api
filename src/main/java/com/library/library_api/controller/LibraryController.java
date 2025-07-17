package com.library.library_api.controller;


import com.library.library_api.Service.LibraryService;
import com.library.library_api.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library") public class LibraryController {
    @Autowired
    LibraryService libraryService;
    @PostMapping("/borrow/userId/{id}/bookId/{bookId}")
    public UserEntity borrowBook(@PathVariable("id") int id, @PathVariable("bookId") int bookId) {
        return libraryService.borrowBook(id,bookId);

    }
}
