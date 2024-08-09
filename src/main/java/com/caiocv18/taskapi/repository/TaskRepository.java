package com.caiocv18.taskapi.repository;

import com.caiocv18.taskapi.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório para gerenciar operações CRUD de tarefas.
 * Esta interface estende MongoRepository, fornecendo métodos prontos para uso
 * para interagir com o banco de dados MongoDB.
 */
@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
    // Os métodos CRUD padrão são herdados de MongoRepository.
    // Não é necessário declarar métodos adicionais aqui, a menos que haja operações personalizadas.
}
