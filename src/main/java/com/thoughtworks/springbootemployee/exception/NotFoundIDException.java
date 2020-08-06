package com.thoughtworks.springbootemployee.exception;

import com.thoughtworks.exception.ExceptionMessage;

public class NotFoundIDException extends Throwable {
    public NotFoundIDException(ExceptionMessage notFoundId) {
    }
}
