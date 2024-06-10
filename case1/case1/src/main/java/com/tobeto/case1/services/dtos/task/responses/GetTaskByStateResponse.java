package com.tobeto.case1.services.dtos.task.responses;

import com.tobeto.case1.entities.concretes.State;
import com.tobeto.case1.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTaskByStateResponse {

    private String title;
    private String description;
    private State state;
    private User user;
}
