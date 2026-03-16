package org.example.exception;

public class DataBaseException extends RuntimeException {
    public DataBaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
