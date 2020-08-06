package com.thoughtworks.config;

import com.thoughtworks.exception.NotFoundIDException;
import com.thoughtworks.exception.NotFoundTodoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = NotFoundIDException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public String notFoundIDExceptionHandler(NotFoundIDException notFoundExceptionHandler) {
        return notFoundExceptionHandler.getMessage();
    }
    @ExceptionHandler(value = NotFoundTodoException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public String notFoundIDExceptionHandler(NotFoundTodoException notFoundExceptionHandler) {
        return notFoundExceptionHandler.getMessage();
    }
}
