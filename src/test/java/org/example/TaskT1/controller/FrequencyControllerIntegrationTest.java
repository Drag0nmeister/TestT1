package org.example.TaskT1.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FrequencyControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testComputeFrequency() throws Exception {
        String testInput = "aaaaabcccc";

        mockMvc.perform(get("/api/v1/frequency")
                        .param("text", testInput)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.a", is(5)))
                .andExpect(jsonPath("$.c", is(4)))
                .andExpect(jsonPath("$.b", is(1)));
    }
}
