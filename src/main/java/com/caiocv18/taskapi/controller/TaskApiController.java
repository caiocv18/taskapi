package com.caiocv18.taskapi.controller;

import com.caiocv18.taskapi.model.Task;
import com.caiocv18.taskapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gerenciar tarefas.
 * Este controlador fornece endpoints para operações CRUD em tarefas.
 */
@RestController // Indica que esta classe é um controlador REST.
@RequestMapping("/api/tasks") // Mapeia as solicitações HTTP para /api/tasks para os métodos deste controlador.
public class TaskApiController {

    private final TaskService taskService;

    @Autowired // Injeta a dependência do serviço de tarefas.
    public TaskApiController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Obtém todas as tarefas.
     *
     * @return uma lista de todas as tarefas
     */
    @GetMapping // Mapeia solicitações HTTP GET para este método.
    public List<Task> getAllTasks() {
        return taskService.findAllTasks();
    }

    /**
     * Cria uma nova tarefa.
     *
     * @param task a tarefa a ser criada
     * @return a tarefa criada
     */
    @PostMapping // Mapeia solicitações HTTP POST para este método.
    public Task createTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    /**
     * Obtém uma tarefa pelo ID.
     *
     * @param id o ID da tarefa
     * @return a tarefa correspondente ao ID
     */
    @GetMapping("/{id}") // Mapeia solicitações HTTP GET para /{id} para este método.
    public Task getTaskById(@PathVariable Long id) {
        return taskService.findTaskById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarefa inválida: " + id));
    }

    /**
     * Atualiza uma tarefa existente.
     *
     * @param id o ID da tarefa a ser atualizada
     * @param task a tarefa atualizada
     * @return a tarefa atualizada
     */
    @PutMapping("/{id}") // Mapeia solicitações HTTP PUT para /{id} para este método.
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        return taskService.updateTask(task);
    }

    /**
     * Exclui uma tarefa pelo ID.
     *
     * @param id o ID da tarefa a ser excluída
     */
    @DeleteMapping("/{id}") // Mapeia solicitações HTTP DELETE para /{id} para este método.
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}