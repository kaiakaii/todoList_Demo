package com.thoughtworks.controller;

import com.thoughtworks.entity.Todo;
import com.thoughtworks.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;
    @GetMapping
    public List<Todo> getAllTodos(){
        return todoService.findAllTodos();
    }
}
