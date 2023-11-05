package com.tribune.backend.domain.error;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DomainException extends RuntimeException{

    private int status;

    public DomainException(String message) {
        super(message);
    }


    public DomainException(int status,String message) {
        super(message);
        this.status=status;
    }
}
