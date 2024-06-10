package com.tobeto.case1.controllers;

import com.tobeto.case1.services.abstracts.TaskService;
import com.tobeto.case1.services.dtos.task.requests.AddTaskRequest;
import com.tobeto.case1.services.dtos.task.requests.UpdateTaskRequest;
import com.tobeto.case1.services.dtos.task.responses.GetAllTaskByDateResponse;
import com.tobeto.case1.services.dtos.task.responses.GetTaskByStateResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/tasks")
public class TasksController {
    private TaskService taskService;

    @PostMapping("/add")
    public void add(@RequestBody @Valid AddTaskRequest request) {
        taskService.add(request);
    }
    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateTaskRequest request) {
        taskService.update(request);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        taskService.delete(id);
    }
    @GetMapping("/getAll")
    public List<GetAllTaskByDateResponse> getAll() {
        return taskService.getAll();
    }
    @PostMapping("/getTaskByStateResponses")
    public List<GetTaskByStateResponse> getTaskByStateResponses(@RequestBody GetTaskByStateResponse request) {
        return taskService.getTaskByState();
    }
}
