package com.thoughtworks.springbootemployee.exception;


import com.thoughtworks.exception.ExceptionMessage;

public class NotFoundIDException extends Exception {
    public NotFoundIDException(ExceptionMessage notFoundId) {
    }
}
