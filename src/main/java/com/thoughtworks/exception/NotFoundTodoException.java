package com.thoughtworks.springbootemployee.exception;

import com.thoughtworks.exception.ExceptionMessage;

public class NotFoundTodoException extends Throwable {
    public NotFoundTodoException(ExceptionMessage notFoundTodo) {
    }
}
