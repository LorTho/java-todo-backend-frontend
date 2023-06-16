package com.josh.backend;


import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class TodoService {

    private final TodoRepo todoRepo;

    public List<Todo> addTodo(Todo todo) {
        return todoRepo.addTodo(todo);
    }
}
