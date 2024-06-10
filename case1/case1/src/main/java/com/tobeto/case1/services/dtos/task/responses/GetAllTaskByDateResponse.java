package com.tobeto.case1.services.dtos.task.responses;

import com.tobeto.case1.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTaskByDateResponse {

    private String title;
    private String description;
    private LocalDate createdDate;
    private User user;
}
