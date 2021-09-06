package com.skytel.challenge.login_backend.exception;

public class InvalidUserException extends RuntimeException {
    private final String message;

    public InvalidUserException (String message) {
        this.message = message + " is invalid";
    }

    public String getMessage() {
        return message;
    }
}
