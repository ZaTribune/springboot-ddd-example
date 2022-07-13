package com.tribune.backend.domain.validation;

import lombok.Value;

@Value
public class ValidationError {
    String path;
    String fieldName;
    Object expectedValue;
    Object actualValue;
    String reason;
}