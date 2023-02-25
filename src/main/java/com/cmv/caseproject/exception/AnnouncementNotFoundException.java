package com.cmv.caseproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AnnouncementNotFoundException extends RuntimeException {
    public AnnouncementNotFoundException() {
        super();
    }
    public AnnouncementNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public AnnouncementNotFoundException(String message) {
        super(message);
    }
}
