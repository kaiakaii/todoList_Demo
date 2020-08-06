package com.thoughtworks.controller;

import com.thoughtworks.entity.Todo;
import com.thoughtworks.service.TodoService;
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
    @CrossOrigin
    public List<Todo> getAllTodos() {
        return todoService.findAllTodos();
    }

    @PostMapping
    @CrossOrigin
    @ResponseStatus(code = HttpStatus.CREATED)
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }
}
