package com.tobeto.case1.services.dtos.task.requests;

import com.tobeto.case1.entities.concretes.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddTaskRequest {

    private String title;
    private String description;
    private State state = State.NEW;
}
