package com.library.library_api.service;


import com.library.library_api.model.BookDto;
import com.library.library_api.model.entity.UserEntity;
import com.library.library_api.model.response.UserResponse;
import com.library.library_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public List<UserResponse> getUsers() {
        List<UserEntity> userEntities = userRepository.findAll();

        return userEntities.stream().map(userDb -> {
            List<BookDto> books = userDb.getLibraryEntity().stream()
                    .map(libraryEntity ->  {
                        return BookDto.builder()
                                .bookId(libraryEntity.getBookEntity().getBookId())
                                .bookName(libraryEntity.getBookEntity().getBookName())
                                .author(libraryEntity.getBookEntity().getAuthor())
                                .status(libraryEntity.getStatus())
                                .build();
                    })
                    .toList();

            return UserResponse.builder()
                    .fullName(userDb.getFullName())
                    .email(userDb.getEmail())
                    .type(userDb.getType())
                    .books(books)
                    .build();
        }).toList();
    }
}
