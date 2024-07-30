package com.caiocv18.taskapi.repository;

import com.caiocv18.taskapi.model.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Repositório para gerenciar tarefas.
 * Este repositório fornece métodos para operações CRUD em tarefas.
 */
public class TaskRepository {

    private final List<Task> tasks = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    /**
     * Salva uma nova tarefa ou atualiza uma tarefa existente.
     *
     * @param task a tarefa a ser salva ou atualizada
     * @return a tarefa salva ou atualizada
     */
    public Task save(Task task) {
        if (task.getId() == null) {
            task.setId(counter.incrementAndGet());
            tasks.add(task);
        } else {
            tasks.set(tasks.indexOf(findById(task.getId()).orElse(null)), task);
        }
        return task;
    }

    /**
     * Obtém todas as tarefas.
     *
     * @return uma lista de todas as tarefas
     */
    public List<Task> findAll() {
        return tasks;
    }

    /**
     * Obtém uma tarefa pelo ID.
     *
     * @param id o ID da tarefa
     * @return uma Optional contendo a tarefa, se encontrada
     */
    public Optional<Task> findById(Long id) {
        return tasks.stream().filter(task -> task.getId().equals(id)).findFirst();
    }

    /**
     * Exclui uma tarefa pelo ID.
     *
     * @param id o ID da tarefa a ser excluída
     */
    public void deleteById(Long id) {
        tasks.removeIf(task -> task.getId().equals(id));
    }
}