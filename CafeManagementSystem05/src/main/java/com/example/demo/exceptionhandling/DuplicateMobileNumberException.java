package com.example.demo.exceptionhandling;

public class DuplicateMobileNumberException extends RuntimeException {
    public DuplicateMobileNumberException(String message) {
        super(message);
    }
}