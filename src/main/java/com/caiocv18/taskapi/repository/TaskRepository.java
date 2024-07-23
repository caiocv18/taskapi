package com.caiocv18.taskapi.repository;

import com.caiocv18.taskapi.model.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class TaskRepository {

    private final List<Task> tasks = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public Task save(Task task) {
        if (task.getId() == null) {
            task.setId(counter.incrementAndGet());
            tasks.add(task);
        } else {
            tasks.set(tasks.indexOf(findById(task.getId()).orElse(null)), task);
        }
        return task;
    }

    public List<Task> findAll() {
        return tasks;
    }

    public Optional<Task> findById(Long id) {
        return tasks.stream().filter(task -> task.getId().equals(id)).findFirst();
    }

    public void deleteById(Long id) {
        tasks.removeIf(task -> task.getId().equals(id));
    }
}