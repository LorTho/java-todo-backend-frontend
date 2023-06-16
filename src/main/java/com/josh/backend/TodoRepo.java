package com.josh.backend;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoRepo {

    private final List<Todo> todos;

    public TodoRepo() {
        this.todos = new ArrayList<>();
    }
}
