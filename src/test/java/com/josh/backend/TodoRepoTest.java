package com.josh.backend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class TodoRepoTest {

    TodoRepo todoRepo = new TodoRepo();

    @Test
    void test_addTodo() {
        // Given
        List<Todo> expected = List.of(
            new Todo(
                "kaffee kochen",
                "OPEN"
            )
        );

        // When
        List<Todo> actual = todoRepo.addTodo();

        // Then
        Assertions.assertEquals(expected, actual);
    }

}
