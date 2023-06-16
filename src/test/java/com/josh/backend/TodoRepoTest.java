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
/*    @Test
    void Test_todoById(){

        //Given
        //Todo expected = new Todo("kaffee kochen", "OPEN");
        //When
        //Todo actual = todoRepo.getTodo(id);
        //Then
        Assertions.assertEquals(expected, actual);

    }*/

}
