package com.tribune.backend.domain.error;

public class QuantityNotPermittedException extends RuntimeException{

    public QuantityNotPermittedException(String message) {
        super(message);
    }
}
