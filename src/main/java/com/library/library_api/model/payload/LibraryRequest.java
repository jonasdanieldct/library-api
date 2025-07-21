package com.library.library_api.model.payload;


import lombok.Data;

@Data
public class LibraryRequest {
    String userId;
    String bookId;
    String transaction;
}
