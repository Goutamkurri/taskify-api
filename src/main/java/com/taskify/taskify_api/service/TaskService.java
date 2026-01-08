package com.taskify.taskify_api.service;

import com.taskify.taskify_api.entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    Task createTask(Task task);

    List<Task> getAllTasks();

    Task getTaskById(Long id);

    Task patchTask(Long id, Task task);

    void deleteTask(Long id);
}
