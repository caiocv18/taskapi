package com.caiocv18.taskapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Representa uma entidade de tarefa no sistema.
 * Esta entidade é mapeada para uma tabela de banco de dados usando anotações JPA.
 */
@Entity // Indica que esta classe é uma entidade JPA.
public class Task {

    @Id // Especifica a chave primária da entidade.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Fornece a especificação das estratégias de geração para os valores das chaves primárias.
    private Long id;

    private String title;

    private String description;

    private String status;

    /**
     * Obtém o ID da tarefa.
     *
     * @return o ID da tarefa
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o ID da tarefa.
     *
     * @param id o novo ID da tarefa
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtém o título da tarefa.
     *
     * @return o título da tarefa
     */
    public String getTitle() {
        return title;
    }

    /**
     * Define o título da tarefa.
     *
     * @param title o novo título da tarefa
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Obtém a descrição da tarefa.
     *
     * @return a descrição da tarefa
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define a descrição da tarefa.
     *
     * @param description a nova descrição da tarefa
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Obtém o status da tarefa.
     *
     * @return o status da tarefa
     */
    public String getStatus() {
        return status;
    }

    /**
     * Define o status da tarefa.
     *
     * @param status o novo status da tarefa
     */
    public void setStatus(String status) {
        this.status = status;
    }
}