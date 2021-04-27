package com.company.Exceptions;

public class FileWritingException extends Exception {

    public FileWritingException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileWritingException(String message) {
        super(message);
    }
}