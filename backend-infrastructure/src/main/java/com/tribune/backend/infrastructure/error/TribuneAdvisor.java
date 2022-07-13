package com.tribune.backend.infrastructure.error;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tribune.backend.domain.dto.GenericResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class TribuneAdvisor extends ResponseEntityExceptionHandler {


    @ExceptionHandler(BackendException.class)
    public ResponseEntity<GenericResponse<ObjectNode>> handleException(BackendException e) {
        log.error("status:{} --- error: {}",e.getStatus(),e.getError());
        GenericResponse<ObjectNode> response=GenericResponse.<ObjectNode>builder()
                .message(e.getMessage())
                .code(e.getStatus().value())
                .data(e.getError())
                .build();
        return ResponseEntity.status(e.getStatus()).body(response);
    }

}
