package com.taskify.taskify_api.service;

import com.taskify.taskify_api.entity.Task;
import com.taskify.taskify_api.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImp implements TaskService {


    private final TaskRepository taskRepository;

    // Add a new task
    public Task createTask(Task task) {
        task.setCreatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }

    // Get all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    //Delete a task using ID
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }



    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public Task patchTask(Long id, Task updatedtask) {
        Task task = getTaskById(id);
        System.out.print(updatedtask);
        task.setTitle(updatedtask.getTitle());
        task.setDescription(updatedtask.getDescription());
        task.setStatus(updatedtask.getStatus());
        return taskRepository.save(task);
    }
}
