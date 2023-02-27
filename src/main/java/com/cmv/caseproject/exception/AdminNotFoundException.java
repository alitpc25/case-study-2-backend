package com.cmv.caseproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AdminNotFoundException extends RuntimeException {
    public AdminNotFoundException() {
        super();
    }
    public AdminNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public AdminNotFoundException(String message) {
        super(message);
    }
}