package com.thoughtworks;

import com.thoughtworks.dao.TodoRepository;
import com.thoughtworks.entity.Todo;
import com.thoughtworks.service.TodoService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class TodoTest {
    private static List<Todo> todos = new ArrayList<>();
    @Mock
    TodoRepository todoRepository;
    @InjectMocks
    TodoService todoService;
    @BeforeAll
    static void init(){
        todos.add(new Todo(1,"sky",false));
        todos.add(new Todo(2,"sky2",false));
    }
    @Test
    void should_return_todos_when_find_all_todos_given_none() {
        //given
        when(todoRepository.findAll()).thenReturn(todos);
        //when
        List<Todo> actualTodos = todoService.findAllTodos();
        //then
        assertEquals(todos.size(),actualTodos.size());
    }

    @Test
    void should_return_todo_when_add_todo_given_todo() {
        //given
        Todo todo = new Todo(3,"sky3",false);
        when(todoRepository.save(todo)).thenReturn(todo);
        //when
        Todo actualTodo = todoService.addTodo(todo);
        //then
        assertNotNull(actualTodo);
        assertEquals(todo.getContent(),actualTodo.getContent());
    }
}
