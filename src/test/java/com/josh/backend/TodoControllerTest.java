package com.josh.backend;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
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
    @DirtiesContext
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
        // ༼ノ◕ヮ◕ ༽ノ︵┻━┻
    @Test
    @DirtiesContext
    void expectListOfTodos_whenGetList() throws Exception {

        //GIVEN
        todoRepo.addTodo(new Todo("kaffee kochen", "OPEN"));

        String expected = """
                            [
                                    {
                                          "description": "kaffee kochen",
                                          "status": "OPEN"
                                    }
                            ]
                            """;

        //WHEN
        mockMvc.perform(
            MockMvcRequestBuilders.get("/api/todo"))

        //THEN
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().json(expected));
    }

    // 乁༼ ☯‿☯✿༽ㄏ
    @Test
    @DirtiesContext
    void expectTodoById() throws Exception {

        //GIVEN
        todoRepo.addTodo(new Todo("kaffee kochen", "OPEN"));
        String id = todoRepo.listTodos().get(0).getId();

        String expected = """
                {
                      "id": "%s",
                      "description": "kaffee kochen",
                      "status": "OPEN"
                }
            """.formatted(id);

        //WHEN
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/todo/{id}", "%s".formatted(id)))

        //THEN
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().json(expected));
    }
}
