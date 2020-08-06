package com.thoughtworks.exception;

public enum ExceptionMessage {
    NOT_FOUND_ID("not found id"),

    NOT_FOUND_TODO("not found todo");

    private String errorMessage;

    ExceptionMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
