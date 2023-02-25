package com.cmv.caseproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NewsNotFoundException extends RuntimeException {
    public NewsNotFoundException() {
        super();
    }
    public NewsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public NewsNotFoundException(String message) {
        super(message);
    }
}
