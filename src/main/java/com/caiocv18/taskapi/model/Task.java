package com.caiocv18.taskapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Representa uma entidade de tarefa no sistema.
 * Esta classe é mapeada para um documento MongoDB na coleção "tasks".
 */
@Document(collection = "tasks")
public class Task {

    /**
     * Identificador único da tarefa.
     * Anotado com @Id para indicar a chave primária do documento MongoDB.
     */
    @Id
    private String id;

    /**
     * Título da tarefa.
     */
    private String title;

    /**
     * Descrição detalhada da tarefa.
     */
    private String description;

    /**
     * Status atual da tarefa (ex: Pendente, Concluída).
     */
    private String status;

    // Getters e setters

    /**
     * Obtém o identificador único da tarefa.
     * @return id da tarefa.
     */
    public String getId() {
        return id;
    }

    /**
     * Define o identificador único da tarefa.
     * @param id o identificador da tarefa.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtém o título da tarefa.
     * @return título da tarefa.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Define o título da tarefa.
     * @param title o título da tarefa.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Obtém a descrição detalhada da tarefa.
     * @return descrição da tarefa.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define a descrição detalhada da tarefa.
     * @param description a descrição da tarefa.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Obtém o status atual da tarefa.
     * @return status da tarefa.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Define o status atual da tarefa.
     * @param status o status da tarefa.
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
