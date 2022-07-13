package com.tribune.backend.infrastructure.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception {
	
	public NotFoundException(String message) {
		super(message);
	}
}
