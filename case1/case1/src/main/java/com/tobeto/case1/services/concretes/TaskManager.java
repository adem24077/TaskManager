package com.tobeto.case1.services.concretes;

import com.tobeto.case1.core.mapper.services.ModelMapperService;
import com.tobeto.case1.entities.concretes.Task;
import com.tobeto.case1.entities.concretes.User;
import com.tobeto.case1.repositories.TaskRepository;
import com.tobeto.case1.repositories.UserRepository;
import com.tobeto.case1.services.abstracts.TaskService;
import com.tobeto.case1.services.dtos.task.requests.AddTaskRequest;
import com.tobeto.case1.services.dtos.task.requests.DeleteTaskRequest;
import com.tobeto.case1.services.dtos.task.requests.UpdateTaskRequest;
import com.tobeto.case1.services.dtos.task.responses.GetAllTaskByDateResponse;
import com.tobeto.case1.services.dtos.task.responses.GetTaskByStateResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskManager implements TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapperService modelMapperService;
    @Override
    public void add(AddTaskRequest request) {
        Task task = this.modelMapperService.forRequest().map(request, Task.class);
        this.taskRepository.save(task);
    }

    @Override
    public void update(UpdateTaskRequest request) {
        Task task = this.modelMapperService.forRequest().map(request,Task.class);
        this.taskRepository.save(task);
    }

    @Override
    public void delete(Integer id) {
        Task taskToDelete = this.taskRepository.findById(id).orElseThrow();
        this.taskRepository.delete(taskToDelete);
    }

    @Override
    public List<GetAllTaskByDateResponse> getAll() {
        List<Task> tasks = taskRepository.findAll();
        List<GetAllTaskByDateResponse> userResponses = tasks.stream()
                .map(user -> this.modelMapperService.forResponse().map(user,GetAllTaskByDateResponse.class)).toList();
        return userResponses;
    }

    @Override
    public List<GetTaskByStateResponse> getTaskByState() {
        return null;
    }
}
