package com.library.library_api.Service;

import com.library.library_api.model.BookEntity;
import com.library.library_api.model.UserEntity;
import com.library.library_api.repository.BookRepository;
import com.library.library_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service

public class LibraryService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    UserRepository userRepository;

    public UserEntity borrowBook(int id, int bookId) {
        UserEntity currentUser = userRepository.findById(id).orElse(null);
        BookEntity currentBook = bookRepository.findByBookId(bookId).orElse(null);

        if(Objects.nonNull(currentUser) && Objects.nonNull(currentBook)) {
            List<BookEntity> dbBooks = Optional.ofNullable(currentUser.getBooks()).orElse(new ArrayList<>());
            List<UserEntity> bookUsers = Optional.ofNullable(currentBook.getUser()).orElse(new ArrayList<>());
            if(!dbBooks.contains(currentBook) && !bookUsers.contains(currentUser)) {
                dbBooks.add(currentBook);
                bookUsers.add(currentUser);
                currentUser.setBooks(dbBooks);
                currentBook.setUser(bookUsers);
            }
            userRepository.save(currentUser);
            bookRepository.save(currentBook);
        }
        return currentUser;
    }

    public UserEntity returnBook(int id, int bookId) {
        UserEntity currentUser = userRepository.findById(id).orElse(null);
        BookEntity currentBook = bookRepository.findByBookId(bookId).orElse(null);

        if(Objects.nonNull(currentUser) && Objects.nonNull(currentBook)) {
            List<BookEntity> dbBooks = Optional.ofNullable(currentUser.getBooks()).orElse(new ArrayList<>());
            List<UserEntity> bookUsers = Optional.ofNullable(currentBook.getUser()).orElse(new ArrayList<>());
            if(dbBooks.contains(currentBook) && bookUsers.contains(currentUser)) {
                dbBooks.remove(currentBook);
                bookUsers.remove(currentUser);
                currentUser.setBooks(dbBooks);
                currentBook.setUser(bookUsers);
            }
            userRepository.save(currentUser);
            bookRepository.save(currentBook);
        }
        return currentUser;
    }


}
