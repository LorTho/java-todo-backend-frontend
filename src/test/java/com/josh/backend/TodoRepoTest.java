package com.josh.backend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class TodoRepoTest {

    TodoRepo todoRepo = mock(TodoRepo.class);

    @Test
    void test_addTodo() {
        // Given
        Todo todo = new Todo(
            "kaffee kochen",
            "OPEN"
        );
        List<Todo> expected = List.of(todo);

        // When
        when(todoRepo.addTodo(todo)).thenReturn(expected);
        List<Todo> actual = todoRepo.addTodo(todo);


        // Then
        Assertions.assertEquals(expected, actual);
        verify(todoRepo).addTodo(todo);
    }

    @Test
    void test_listTodos() {
        //GIVEN
        List<Todo> expected = new ArrayList<>();
        //WHEN
        List<Todo> actual = todoRepo.listTodos();

        //THEN
        Assertions.assertEquals(expected, actual);

    }
    @Test
    void Test_todoById(){
        //Given
        TodoRepo todoRepo2 = new TodoRepo();
        Todo todo = new Todo(
            "kaffee kochen",
            "OPEN"
        );
        todoRepo2.addTodo(todo);
        String id = todoRepo2.listTodos().get(0).getId();
        Todo expected = todoRepo2.listTodos().get(0);

        //When
        Todo actual = todoRepo2.getTodoById(id);

        //Then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void Test_deleteById(){
        //Given
        TodoRepo todoRepo3 = new TodoRepo();
        Todo todo = new Todo(
            "kaffee kochen",
            "OPEN"
        );
        todoRepo3.addTodo(todo);
        todoRepo3.addTodo(todo);
        String idToRemove = todoRepo3.listTodos().get(0).getId();
        String idToRemain = todoRepo3.listTodos().get(1).getId();
        List<Todo> expected = List.of(todoRepo3.getTodoById(idToRemain));

        //When
        Todo actual = todoRepo3.getTodoById(idToRemove);

        //Then
        Assertions.assertEquals(expected, actual);
    }

}
