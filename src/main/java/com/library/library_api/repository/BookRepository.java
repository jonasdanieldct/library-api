package com.library.library_api.repository;

import com.library.library_api.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<BookEntity,Integer> {
    Optional<BookEntity> findByBookId(int bookId);
}
