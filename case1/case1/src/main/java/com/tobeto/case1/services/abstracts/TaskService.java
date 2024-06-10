package com.tobeto.case1.services.abstracts;

import com.tobeto.case1.entities.concretes.State;
import com.tobeto.case1.services.dtos.task.requests.AddTaskRequest;
import com.tobeto.case1.services.dtos.task.requests.DeleteTaskRequest;
import com.tobeto.case1.services.dtos.task.requests.UpdateTaskRequest;
import com.tobeto.case1.services.dtos.task.responses.GetAllTaskByDateResponse;
import com.tobeto.case1.services.dtos.task.responses.GetTaskByStateResponse;

import java.util.List;

public interface TaskService {
    void add(AddTaskRequest addTaskRequest);
    void update(UpdateTaskRequest updateTaskRequest);
    void delete(Integer id);
    List<GetAllTaskByDateResponse> getAll();
    List<GetTaskByStateResponse> getTaskByState();

}
