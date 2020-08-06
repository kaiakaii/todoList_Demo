package com.thoughtworks.service;

import com.thoughtworks.dao.TodoRepository;
import com.thoughtworks.entity.Todo;
import com.thoughtworks.exception.ExceptionMessage;
import com.thoughtworks.exception.NotFoundIDException;
import com.thoughtworks.exception.NotFoundTodoException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findAllTodos(){
        return todoRepository.findAll();
    }

    public Todo addTodo(Todo todo) throws NotFoundTodoException {
        if(Objects.isNull(todo)){
            throw new NotFoundTodoException(ExceptionMessage.NOT_FOUND_TODO);
        }
        if (Objects.isNull(todo.getStatus())){
            todo.setStatus(false);
        }
        return todoRepository.save(todo);
    }

    public Todo updateTodo(int todoId, Todo updateTodo) throws NotFoundTodoException {
        Todo todo = todoRepository.findById(todoId).orElseThrow(()-> new NotFoundTodoException(ExceptionMessage.NOT_FOUND_ID));
        BeanUtils.copyProperties(updateTodo,todo);
        return todoRepository.save(todo);
    }

    public boolean deleteTodo(int todoId) throws NotFoundIDException {
        if (Objects.isNull(todoRepository.findById(todoId))){
            throw new NotFoundIDException(ExceptionMessage.NOT_FOUND_ID);
        }
         todoRepository.deleteById(todoId);
        return true;
    }
}
