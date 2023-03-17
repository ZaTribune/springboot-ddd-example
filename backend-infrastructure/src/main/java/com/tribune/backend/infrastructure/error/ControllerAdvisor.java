package com.tribune.backend.infrastructure.error;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tribune.backend.domain.dto.GenericResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {


    @ExceptionHandler(BackendException.class)
    public ResponseEntity<GenericResponse<ObjectNode>> handleException(BackendException e) {
        log.error("status:{} --- error: {}", e.getStatus(), e.getError());
        GenericResponse<ObjectNode> response = GenericResponse.<ObjectNode>builder()
                .message(e.getMessage())
                .code(e.getStatus().value())
                .data(e.getError())
                .build();
        return ResponseEntity.status(e.getStatus()).body(response);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<GenericResponse<ObjectNode>> handleException(ResponseStatusException e) {
        log.error("status:{} --- error: {}", e.getStatus(), e.getMessage());
        GenericResponse<ObjectNode> response = GenericResponse.<ObjectNode>builder()
                .message(e.getReason())
                .code(e.getStatus().value())
                .build();
        return ResponseEntity.status(e.getStatus()).body(response);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException e, HttpHeaders headers, HttpStatus status, WebRequest request) {
        GenericResponse<ObjectNode> response = GenericResponse.<ObjectNode>builder()
                .message(e.getMessage())
                .code(HttpStatus.BAD_REQUEST.value())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers, HttpStatus status, WebRequest request) {

        String message = "Error occurred!";
        FieldError fieldError = e.getFieldError();

        if (fieldError != null) {
            message = String.format("[%s] %s",fieldError.getField(),fieldError.getDefaultMessage());
        }

        GenericResponse<ObjectNode> response = GenericResponse.<ObjectNode>builder()
                .message(message)
                .code(HttpStatus.BAD_REQUEST.value())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

}
