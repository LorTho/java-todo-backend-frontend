package com.josh.backend;

import lombok.Data;

import java.util.UUID;

@Data
public class Todo {

    String id;
    String description;
    Status status;

    public Todo(String description, Status status) {
        this.id = UUID.randomUUID().toString().substring(0, 4);
        this.description = description;
        this.status = status;
    }
}
