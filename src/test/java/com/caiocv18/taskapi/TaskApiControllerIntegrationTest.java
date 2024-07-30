package com.caiocv18.taskapi;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Classe de teste para o controlador de tarefas.
 * Esta classe contém testes de integração para os métodos do controlador de tarefas.
 */
@SpringBootTest // Indica que este é um teste de integração que inicializa o contexto do Spring Boot.
@AutoConfigureMockMvc // Configura e injeta o MockMvc.
public class TaskApiControllerIntegrationTest {

    @Autowired // Injeta a dependência do MockMvc.
    private MockMvc mockMvc;

    /**
     * Testa o endpoint de listagem de tarefas.
     * Verifica se o endpoint retorna o status 200 (OK).
     */
    @Test // Indica que este método é um teste de unidade.
    public void testGetTasks() throws Exception {
        this.mockMvc.perform(get("/api/tasks"))
                .andExpect(status().isOk());
    }
}
