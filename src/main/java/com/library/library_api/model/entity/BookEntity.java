package com.library.library_api.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "book_entity")
@Data
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String bookId;
    private String bookName;
    private String author;

    @OneToMany(mappedBy = "bookEntity",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<LibraryEntity> libraryEntity;

}
