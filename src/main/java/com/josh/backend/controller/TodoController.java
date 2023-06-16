package com.josh.backend.controller;


import com.josh.backend.Todo;
import com.josh.backend.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }


    @PostMapping("/todo")
    public List<Todo> addTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }

}
