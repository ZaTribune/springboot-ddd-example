package com.tribune.backend.infrastructure.error;

import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class BackendException extends RuntimeException{

   private final ObjectNode error;
   private final HttpStatus status;

    public BackendException(ObjectNode error, HttpStatus status) {
        this.error= error;
        this.status=status;
    }
}
