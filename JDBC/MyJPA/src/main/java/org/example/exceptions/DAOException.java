package org.example.exceptions;

public class DAOException extends RuntimeException {
    public DAOException(String message) {
        super(message);
    }
}
