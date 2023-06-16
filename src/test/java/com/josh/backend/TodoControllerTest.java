package com.josh.backend;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class TodoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    TodoRepo todoRepo;

    @Test
    void expectUpdatedList_WhenAddingATodo() throws Exception {
        // Given
        String expected = """
            [
                {
                    description: "kaffee kochen",
                    status: "OPEN"
                }
            ]
            """;

        // When
        mockMvc.perform(
            MockMvcRequestBuilders.post("/api/todo")
        )

        // Then
            .andExpect(
                MockMvcResultMatchers.content().json(expected)
            );
    }

}
