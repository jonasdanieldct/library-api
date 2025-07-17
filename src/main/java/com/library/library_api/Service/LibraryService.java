package com.library.library_api.Service;

import com.library.library_api.model.BookEntity;
import com.library.library_api.model.UserEntity;
import com.library.library_api.repository.BookRepository;
import com.library.library_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

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
            currentUser.getBooks().add(currentBook);
            currentBook.setUser(currentUser);
            userRepository.save(currentUser);
            bookRepository.save(currentBook);
        }
        return currentUser;
    }


}
