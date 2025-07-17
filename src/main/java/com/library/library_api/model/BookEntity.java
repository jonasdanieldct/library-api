package com.library.library_api.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "BOOK_ENTITY")
@Data
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookId;
    private String bookName;

    @ManyToMany
    @JsonIgnore
    private List<UserEntity> user;

}
