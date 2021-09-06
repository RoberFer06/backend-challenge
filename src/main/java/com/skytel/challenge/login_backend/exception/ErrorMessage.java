package com.skytel.challenge.login_backend.exception;

import java.util.List;

public class ErrorMessage {

    private Integer status;

    private final List<String> errors;
    private final String message;
    private final String path ;

    public ErrorMessage(Integer status, List<String> errors, String message, String path) {
        this.status = status;
        this.errors = errors;
        this.message = message;
        this.path = path;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public List<String> getErrors() {
        return errors;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "status=" + status +
                ", errors=" + errors +
                ", message='" + message + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}