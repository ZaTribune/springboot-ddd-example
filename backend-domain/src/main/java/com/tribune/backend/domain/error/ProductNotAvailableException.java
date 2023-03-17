package com.tribune.backend.domain.error;

public class ProductNotAvailableException extends RuntimeException{

    public ProductNotAvailableException(String message) {
        super(message);
    }
}
