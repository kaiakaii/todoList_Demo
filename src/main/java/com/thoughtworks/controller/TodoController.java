package com.thoughtworks.controller;

import com.thoughtworks.entity.Todo;
import com.thoughtworks.service.TodoService;
import com.thoughtworks.exception.NotFoundIDException;
import com.thoughtworks.exception.NotFoundTodoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.findAllTodos();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Todo addTodo(@RequestBody Todo todo) throws NotFoundTodoException {
        return todoService.addTodo(todo);
    }

    @PutMapping(path = "/{id}")
    public Todo updateTodo(@PathVariable Integer id,@RequestBody Todo todo) throws NotFoundTodoException {
        return todoService.updateTodo(id,todo);
    }
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteTodo(@PathVariable Integer id) throws NotFoundIDException {
        todoService.deleteTodo(id);
    }
}
