package com.vigulear.vaadinapp.data.exception_handling.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
