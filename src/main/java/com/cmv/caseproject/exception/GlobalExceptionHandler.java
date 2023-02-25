package com.cmv.caseproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	   @ExceptionHandler(value = AnnouncementNotFoundException.class)
	   public ResponseEntity<Object> announcementNotFoundHandler(AnnouncementNotFoundException exception) {
	      return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	   }
	   
	   @ExceptionHandler(value = FilenameAlreadyInUseException.class)
	   public ResponseEntity<Object> filenameAlreadyInUseHandler(FilenameAlreadyInUseException exception) {
	      return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	   }
	   
	   @ExceptionHandler(value = NewsNotFoundException.class)
	   public ResponseEntity<Object> newsNotFoundHandler(NewsNotFoundException exception) {
	      return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	   }
	   
	   @ExceptionHandler(value = BadCredentialsException.class)
	   public ResponseEntity<Object> badCredentialsHandler(BadCredentialsException exception) {
	      return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	   }
	   
	   @ExceptionHandler(value = AuthenticationException.class)
	   public ResponseEntity<Object> handleAuthenticationException(AuthenticationException exception) {
	      return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNAUTHORIZED);
	   }
	   
}