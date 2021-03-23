package com.managmentcampainapp.demo.exception;

public class BudgetToLowException extends RuntimeException {
    public BudgetToLowException(String message) {
        super(message);
    }
}
