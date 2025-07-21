package com.library.library_api.controller;


import com.library.library_api.model.payload.LibraryRequest;
import com.library.library_api.model.response.LibraryResponse;
import com.library.library_api.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library") public class LibraryController {
    @Autowired
    LibraryService libraryService;
    @PostMapping
    public ResponseEntity<LibraryResponse> borrowBook(@RequestBody LibraryRequest request) {
        if("borrow".equalsIgnoreCase(request.getTransaction())){
            return new ResponseEntity<>(libraryService.borrowBook(request.getUserId(), request.getBookId()), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(libraryService.returnBook(request.getUserId(), request.getBookId()), HttpStatus.OK);
        }
    }
}
