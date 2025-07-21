package com.library.library_api.repository;

import com.library.library_api.model.entity.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibraryRepository extends JpaRepository<LibraryEntity,String> {
}
