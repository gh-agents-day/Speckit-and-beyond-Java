package com.speckit.taskmanager.service;

import com.speckit.taskmanager.model.Task;
import com.speckit.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Optional<Task> getTaskById(String id) {
        return repository.findById(id);
    }

    public Task createTask(Task task) {
        task.setId(UUID.randomUUID().toString());
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
        if (task.getStatus() == null || task.getStatus().isBlank()) {
            task.setStatus("TODO");
        }
        return repository.save(task);
    }

    public Optional<Task> updateTask(String id, Task updated) {
        return repository.findById(id).map(existing -> {
            existing.setTitle(updated.getTitle());
            existing.setDescription(updated.getDescription());
            existing.setStatus(updated.getStatus());
            existing.setCategory(updated.getCategory());
            existing.setAssignedTo(updated.getAssignedTo());
            existing.setDueDate(updated.getDueDate());
            existing.setUpdatedAt(LocalDateTime.now());
            return repository.save(existing);
        });
    }

    public boolean deleteTask(String id) {
        return repository.deleteById(id);
    }
}
