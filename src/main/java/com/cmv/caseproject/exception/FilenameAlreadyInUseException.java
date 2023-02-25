package com.cmv.caseproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class FilenameAlreadyInUseException extends RuntimeException {
    public FilenameAlreadyInUseException() {
        super();
    }
    public FilenameAlreadyInUseException(String message, Throwable cause) {
        super(message, cause);
    }
    public FilenameAlreadyInUseException(String message) {
        super(message);
    }
}
