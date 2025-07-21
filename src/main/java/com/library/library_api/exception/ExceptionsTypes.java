package com.library.library_api.exception;

import lombok.Getter;

@Getter
public enum ExceptionsTypes {

    NOT_EXISTS_RECORD("ERROR_001","Record doesn't exist"),
    EXISTING_BOOK("ERROR_002","Book already borrowed"),
    NO_BOOK("ERROR_003","User have not borrowed book");

    ExceptionsTypes(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    final String errorCode;
    final String errorMessage;

}
