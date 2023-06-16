package com.josh.backend;


import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class TodoService {

    private final TodoRepo todoRepo;

}
