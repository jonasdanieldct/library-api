package com.library.library_api.model.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "user_entity")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String fullName;
    @Column(unique = true)
    String email;
    String type;

    @OneToMany(mappedBy = "userEntity")
    private List<LibraryEntity> libraryEntity;
}
