package com.example.finalproject.Exceptions;

public class UnableToSubmitOrderException extends RuntimeException{

    public UnableToSubmitOrderException() {
    }

    public UnableToSubmitOrderException(String message) {
        super(message);
    }

    public UnableToSubmitOrderException(String message, Throwable cause) {
        super(message, cause);
    }
}
