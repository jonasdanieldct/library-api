package com.library.library_api.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "USER_ENTITY")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String fullName;
    @Column(unique = true)
    String email;
    String type;
}
