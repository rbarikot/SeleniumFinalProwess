package com.API.exceptions;

public class POJOException extends RuntimeException {
    public POJOException(String message) {
        super(message);
    }
    public POJOException(String message, Throwable cause) {super(message, cause);}
}
