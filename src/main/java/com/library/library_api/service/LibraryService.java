package com.library.library_api.service;

import com.library.library_api.exception.ExceptionsTypes;
import com.library.library_api.exception.LibraryException;
import com.library.library_api.model.entity.BookEntity;
import com.library.library_api.model.entity.LibraryEntity;
import com.library.library_api.model.entity.UserEntity;
import com.library.library_api.model.response.LibraryResponse;
import com.library.library_api.repository.BookRepository;
import com.library.library_api.repository.LibraryRepository;
import com.library.library_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service

public class LibraryService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    LibraryRepository libraryRepository;

    public LibraryResponse returnBook(String id, String bookId) {
        UserEntity currentUser = userRepository.findById(id)
                .orElseThrow(() -> new LibraryException(ExceptionsTypes.NOT_EXISTS_RECORD));
        BookEntity currentBook = bookRepository.findByBookId(bookId)
                .orElseThrow(() -> new LibraryException(ExceptionsTypes.NOT_EXISTS_RECORD));
        LibraryEntity libraryEntity = currentUser.getLibraryEntity().stream()
                .filter(lib -> lib.getBookEntity().equals(currentBook))
                .findFirst().orElseThrow(() -> new LibraryException(ExceptionsTypes.NOT_EXISTS_RECORD));

        libraryEntity.setDateReturned(LocalDateTime.now());
        libraryEntity.setStatus("RETURNED");

        libraryRepository.save(libraryEntity);
        return LibraryResponse.builder()
                .user(currentUser.getFullName())
                .bookName(currentBook.getBookName())
                .transaction("RETURNED").build();
    }

    public LibraryResponse borrowBook(String id, String bookId) {
        UserEntity currentUser = userRepository.findById(id)
                .orElseThrow(() -> new LibraryException(ExceptionsTypes.NOT_EXISTS_RECORD));
        BookEntity currentBook = bookRepository.findByBookId(bookId)
                .orElseThrow(() -> new LibraryException(ExceptionsTypes.NOT_EXISTS_RECORD));

            boolean bookExists = currentUser.getLibraryEntity().stream()
                    .filter(lib -> "BORROWED".equals(lib.getStatus()))
                    .map(LibraryEntity::getBookEntity)
                    .anyMatch(books ->bookId.equalsIgnoreCase(books.getBookId()));

            if(bookExists) {
                throw new LibraryException(ExceptionsTypes.EXISTING_BOOK);
            }

            LibraryEntity libraryEntity = LibraryEntity.builder()
                    .userEntity(currentUser)
                    .bookEntity(currentBook)
                    .status("BORROWED")
                    .dateBorrowed(LocalDateTime.now())
                    .build();
            libraryRepository.save(libraryEntity);

            return LibraryResponse.builder()
                    .user(currentUser.getFullName())
                    .bookName(currentBook.getBookName())
                    .transaction("BORROW").build();
    }
}
