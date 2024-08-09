package com.caiocv18.taskapi.service;

import com.caiocv18.taskapi.model.Task;
import com.caiocv18.taskapi.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Serviço para gerenciar tarefas.
 * Este serviço fornece métodos para operações CRUD em tarefas.
 */
@Service // Indica que esta classe é um serviço do Spring.
public class TaskService {

    private final TaskRepository taskRepository;

    /**
     * Construtor do serviço de tarefas.
     * Injeta a dependência do repositório de tarefas.
     */
    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * Salva uma nova tarefa.
     *
     * @param task a tarefa a ser salva
     * @return a tarefa salva
     */
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    /**
     * Obtém todas as tarefas.
     *
     * @return uma lista de todas as tarefas
     */
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    /**
     * Obtém uma tarefa pelo ID.
     *
     * @param id o ID da tarefa
     * @return uma Optional contendo a tarefa, se encontrada
     */
    public Optional<Task> findTaskById(String id) {
        return taskRepository.findById(id);
    }

    /**
     * Atualiza uma tarefa existente.
     *
     * @param task a tarefa a ser atualizada
     * @return a tarefa atualizada
     */
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    /**
     * Exclui uma tarefa pelo ID.
     *
     * @param id o ID da tarefa a ser excluída
     */
    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }
}
