package com.movevoyage.user_service.payload.exceptions;

public class UserValidationException extends RuntimeException{
    public UserValidationException(String message) {
        super(message);
    }
}
