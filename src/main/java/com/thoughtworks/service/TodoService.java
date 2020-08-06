package com.thoughtworks.service;

import com.thoughtworks.dao.TodoRepository;
import com.thoughtworks.entity.Todo;
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

    public Todo addTodo(Todo todo) {
        if(Objects.isNull(todo)){
            return null;
        }
        return todoRepository.save(todo);
    }
}
