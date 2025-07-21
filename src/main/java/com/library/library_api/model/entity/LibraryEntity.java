package com.library.library_api.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "library_entity")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LibraryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String libraryId;
    String status;
    LocalDateTime dateBorrowed;
    LocalDateTime dateReturned;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity bookEntity;
}
