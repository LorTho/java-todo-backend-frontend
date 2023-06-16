package com.josh.backend;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoRepo {

    private final List<Todo> todos;

    public TodoRepo() {
        this.todos = new ArrayList<>();
    }

    public List<Todo> addTodo(Todo todo) {
        todos.add(todo);
        return todos;
    }
}
