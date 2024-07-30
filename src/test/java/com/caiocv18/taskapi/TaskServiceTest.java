package com.caiocv18.taskapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.caiocv18.taskapi.model.Task;
import com.caiocv18.taskapi.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe de teste para o serviço de tarefas.
 * Esta classe contém testes unitários para os métodos do serviço de tarefas.
 */
public class TaskServiceTest {

    private TaskService taskService;

    /**
     * Configuração inicial antes de cada teste.
     * Inicializa a instância do serviço de tarefas.
     */
    @BeforeEach // Indica que este método deve ser executado antes de cada teste.
    public void setup() {
        taskService = new TaskService();
    }

    /**
     * Testa o método de salvar tarefa.
     * Verifica se a tarefa é salva corretamente.
     */
    @Test // Indica que este método é um teste de unidade.
    public void testSaveTask() {
        Task task = new Task();
        task.setTitle("Nova Tarefa");
        task.setDescription("Descrição da nova tarefa");
        task.setStatus("Pendente");

        Task savedTask = taskService.saveTask(task);

        assertEquals(task.getTitle(), savedTask.getTitle());
        assertEquals(task.getDescription(), savedTask.getDescription());
        assertEquals(task.getStatus(), savedTask.getStatus());
    }

    /**
     * Testa o método de atualizar tarefa.
     * Verifica se a tarefa é atualizada corretamente.
     */
    @Test // Indica que este método é um teste de unidade.
    public void testUpdateTask() {
        Task task = new Task();
        task.setTitle("Tarefa Existente");
        task.setDescription("Descrição da tarefa existente");
        task.setStatus("Concluída");

        Task updatedTask = taskService.updateTask(task);

        assertEquals(task.getTitle(), updatedTask.getTitle());
        assertEquals(task.getDescription(), updatedTask.getDescription());
        assertEquals(task.getStatus(), updatedTask.getStatus());
    }
}