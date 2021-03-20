package com.managmentcampainapp.demo.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({IdNotFoundException.class})
    public ResponseEntity<String> handleNotFoundExceptions(IdNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), NOT_FOUND);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<String> handleViolationExceptions(ConstraintViolationException exception) {
        return new ResponseEntity<>(exception.getMessage(), NOT_ACCEPTABLE);
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity<String> handleViolationExceptions(DataIntegrityViolationException exception) {
        return new ResponseEntity<>("Name already used", NOT_ACCEPTABLE);
    }

}
