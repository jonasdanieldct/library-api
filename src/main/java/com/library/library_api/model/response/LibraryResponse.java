package com.library.library_api.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LibraryResponse {
    private String user;
    private String bookName;
    private String transaction;
}
