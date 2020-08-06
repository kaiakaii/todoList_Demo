package com.thoughtworks.service;

import com.thoughtworks.dao.TodoRepository;
import com.thoughtworks.entity.Todo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
        if (Objects.isNull(todo.getStatus())){
            todo.setStatus(false);
        }
        return todoRepository.save(todo);
    }

    public Todo updateTodo(int todoId, Todo upadateTodo) {
        Todo todo = todoRepository.findById(todoId).orElse(null);
        if (Objects.isNull(todo)){
            return null;
        }
        upadateTodo.setId(todoId);
        return todoRepository.save(upadateTodo);
    }

    public boolean deleteTodo(int todoId) {
        if (Objects.isNull(todoRepository.findById(todoId))){
            return false;
        }
         todoRepository.deleteById(todoId);
        return true;
    }
}
