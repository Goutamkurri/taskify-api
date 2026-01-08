package com.taskify.taskify_api.controller;

import com.taskify.taskify_api.entity.Task;
import com.taskify.taskify_api.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /** View all tasks
     * LOCAL HOST URL FOR POSTMAN    POST METHOD  http://localhost:8080/tasks
     **/
    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        Task savedTask = taskService.createTask(task);
        return ResponseEntity.ok(savedTask);
    }

    /** View all tasks
     * LOCAL HOST URL FOR POSTMAN  GET METHOD http://localhost:8080/tasks
    **/
    @GetMapping
    public ResponseEntity<List<Task>> viewTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok("Deleted");
    }

    @PatchMapping("/updatetask/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id,
                                           @RequestBody Task updatedtask){
        return ResponseEntity.ok(taskService.patchTask(id, updatedtask));
    }




}
