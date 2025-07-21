package com.library.library_api.exception;

public class LibraryException extends RuntimeException {
    ExceptionsTypes exceptionsTypes;
    public LibraryException(ExceptionsTypes exceptionsTypes) {
        super(exceptionsTypes.errorCode + " : " + exceptionsTypes.errorMessage);
    }
}
