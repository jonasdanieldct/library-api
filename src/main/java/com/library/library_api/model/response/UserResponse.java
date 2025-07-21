package com.library.library_api.model.response;


import com.library.library_api.model.BookDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserResponse {
    String fullName;
    String email;
    String type;
    List<BookDto> books;
}
