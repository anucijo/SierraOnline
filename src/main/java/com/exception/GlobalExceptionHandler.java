package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
 
    @ExceptionHandler(value = {InvalidLoginException.class})
    protected ResponseEntity<Object> handleInvalidLogin(WebRequest request) {
        return new ResponseEntity<>("Invalid UserName or Password", HttpStatus.BAD_REQUEST);
    }
	
    @ExceptionHandler(value = {DuplicateUserNameException.class})
    protected ResponseEntity<Object> handleDuplicateUser(WebRequest request) {
        return new ResponseEntity<>("Duplicate UserName", HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handleException(RuntimeException ex, WebRequest request) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
