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

        // When
        mockMvc.perform(
            MockMvcRequestBuilders.post("/api/todo")
                .contentType("application/json")
                .content("""
                    {
                        "description": "kaffee kochen",
                        "status": "OPEN"
                    }
                    """)
        )

        // Then
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].description").value("kaffee kochen"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].status").value("OPEN"));
    }
}
