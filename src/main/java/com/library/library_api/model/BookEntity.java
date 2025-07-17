package com.library.library_api.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "BOOK_ENTITY")
@Data
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookId;
    private String bookName;

    @ManyToOne
    @JoinColumn(name ="id")
    @JsonBackReference
    private UserEntity user;

}
