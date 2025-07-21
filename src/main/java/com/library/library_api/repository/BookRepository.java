package com.library.library_api.repository;

import com.library.library_api.model.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<BookEntity,String> {
    Optional<BookEntity> findByBookId(String bookId);
}
