package com.thoughtworks.mapper;

import com.thoughtworks.dto.RequestTodo;
import com.thoughtworks.dto.ResponseTodo;
import com.thoughtworks.entity.Todo;
import org.springframework.beans.BeanUtils;

public class TodoMapper {
    public static Todo toTodo(RequestTodo requestTodo){
        Todo todo = new Todo();
        BeanUtils.copyProperties(requestTodo,todo);
        return todo;
    }
    public static ResponseTodo toResponseTodo(Todo todo){
        ResponseTodo responseTodo = new ResponseTodo();
        BeanUtils.copyProperties(responseTodo,todo);
        return responseTodo;
    }
}
