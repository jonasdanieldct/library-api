package com.library.library_api.model;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class BookDto {
    private String bookId;
    private String bookName;
    private String author;
    private String status;
}
