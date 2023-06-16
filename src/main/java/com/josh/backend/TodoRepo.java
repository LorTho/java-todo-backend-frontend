package com.josh.backend;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<Todo> listTodos() {
        return this.todos;
    }

    public Todo getTodoById(String id) {
        Optional<Todo> optional = this.todos.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst();
        return optional.orElse(null);
    }

    public List<Todo> updateTodoById(String id, Todo todo) {
        todo.setId(id);
        for (int i = 0; i < this.todos.size(); i++) {
            if (this.todos.get(i).getId().equals(id)) {
                this.todos.set(i, todo);
            }
        }
        return this.todos;
    }

    public List<Todo> deleteTodoById(String id) {
        this.todos.removeIf(todo -> todo.getId().equals(id));
        return this.todos;
    }
}
