package com.caiocv18.taskapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import com.caiocv18.taskapi.model.Task;
import com.caiocv18.taskapi.repository.TaskRepository;
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
        TaskRepository taskRepository = mock(TaskRepository.class); // Cria um mock do repositório de tarefas.
        taskService = new TaskService(taskRepository); // Inicializa o serviço de tarefas com o repositório mockado.
    }

    /**
     * Testa o método de salvar tarefa.
     * Verifica se a tarefa é salva corretamente.
     */
    @Test // Indica que este método é um teste de unidade.
    public void testSaveTask() {
        Task task = new Task(); // Cria uma nova instância de Task.
        task.setTitle("Nova Tarefa"); // Define o título da tarefa.
        task.setDescription("Descrição da nova tarefa"); // Define a descrição da tarefa.
        task.setStatus("Pendente"); // Define o status da tarefa.

        Task savedTask = taskService.saveTask(task); // Salva a tarefa usando o serviço de tarefas.

        // Verifica se os campos da tarefa salva são iguais aos da tarefa original.
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
        Task task = new Task(); // Cria uma nova instância de Task.
        task.setTitle("Tarefa Existente"); // Define o título da tarefa.
        task.setDescription("Descrição da tarefa existente"); // Define a descrição da tarefa.
        task.setStatus("Concluída"); // Define o status da tarefa.

        Task updatedTask = taskService.updateTask(task); // Atualiza a tarefa usando o serviço de tarefas.

        // Verifica se os campos da tarefa atualizada são iguais aos da tarefa original.
        assertEquals(task.getTitle(), updatedTask.getTitle());
        assertEquals(task.getDescription(), updatedTask.getDescription());
        assertEquals(task.getStatus(), updatedTask.getStatus());
    }
}