package com.speckit.taskmanager.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.speckit.taskmanager.model.Task;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TaskRepository {

    private final File dataFile;
    private final ObjectMapper mapper;

    public TaskRepository(@Value("${app.data.file:data/tasks.json}") String dataFilePath) {
        this.dataFile = new File(dataFilePath);
        this.mapper = new ObjectMapper();
        this.mapper.registerModule(new JavaTimeModule());
        this.mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        this.mapper.enable(SerializationFeature.INDENT_OUTPUT);
        ensureFileExists();
    }

    private void ensureFileExists() {
        try {
            if (!dataFile.getParentFile().exists()) {
                dataFile.getParentFile().mkdirs();
            }
            if (!dataFile.exists()) {
                mapper.writeValue(dataFile, new ArrayList<>());
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot initialise task data file: " + dataFile.getAbsolutePath(), e);
        }
    }

    public List<Task> findAll() {
        try {
            return mapper.readValue(dataFile, new TypeReference<List<Task>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException("Failed to read tasks", e);
        }
    }

    public Optional<Task> findById(String id) {
        return findAll().stream().filter(t -> t.getId().equals(id)).findFirst();
    }

    public Task save(Task task) {
        List<Task> tasks = findAll();
        tasks.removeIf(t -> t.getId().equals(task.getId()));
        tasks.add(task);
        persist(tasks);
        return task;
    }

    public boolean deleteById(String id) {
        List<Task> tasks = findAll();
        boolean removed = tasks.removeIf(t -> t.getId().equals(id));
        if (removed)
            persist(tasks);
        return removed;
    }

    private void persist(List<Task> tasks) {
        try {
            mapper.writeValue(dataFile, tasks);
        } catch (IOException e) {
            throw new RuntimeException("Failed to persist tasks", e);
        }
    }
}
