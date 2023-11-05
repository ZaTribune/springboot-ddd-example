package com.tribune.backend.infrastructure.error;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tribune.backend.domain.dto.GenericResponse;
import com.tribune.backend.domain.error.DomainException;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {


    @ExceptionHandler(DomainException.class)
    public ResponseEntity<GenericResponse<ObjectNode>> handleException(DomainException e) {
        log.error("status:{} --- error: {}", e.getStatus(), e.getMessage());
        GenericResponse<ObjectNode> response = GenericResponse.<ObjectNode>builder()
                .message(e.getMessage())
                .code(e.getStatus())
                .build();
        return ResponseEntity.status(e.getStatus()).body(response);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<GenericResponse<ObjectNode>> handleException(ResponseStatusException e) {
        log.error("status:{} --- error: {}", e.getStatusCode(), e.getMessage());
        GenericResponse<ObjectNode> response = GenericResponse.<ObjectNode>builder()
                .message(e.getReason())
                .code(e.getStatusCode().value())
                .build();
        return ResponseEntity.status(e.getStatusCode()).body(response);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException e,
                                                                  @NonNull HttpHeaders headers,
                                                                  @NonNull HttpStatusCode status,
                                                                  @NonNull WebRequest request) {

        GenericResponse<ObjectNode> response = GenericResponse.<ObjectNode>builder()
                .message(e.getMessage())
                .code(HttpStatus.BAD_REQUEST.value())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e,
                                                                  @NonNull HttpHeaders headers,
                                                                  @NonNull HttpStatusCode status,
                                                                  @NonNull WebRequest request) {

        String message = "Error occurred!";
        FieldError fieldError = e.getFieldError();

        if (fieldError != null) {
            message = String.format("[%s] %s", fieldError.getField(), fieldError.getDefaultMessage());
        }

        GenericResponse<ObjectNode> response = GenericResponse.<ObjectNode>builder()
                .message(message)
                .code(HttpStatus.BAD_REQUEST.value())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

}
