package com.tribune.backend.domain.error;

public class CustomerInvalidStateException extends RuntimeException{

    public CustomerInvalidStateException(String message) {
        super(message);
    }
}
