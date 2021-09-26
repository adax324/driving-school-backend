package com.example.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> exception(RuntimeException exception){
        return new ResponseEntity<>("Testowy Błąd", HttpStatus.BAD_REQUEST);
    }
}
