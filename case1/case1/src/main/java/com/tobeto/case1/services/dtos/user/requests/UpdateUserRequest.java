package com.tobeto.case1.services.dtos.user.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {

    private int id;

    private String username;

    private String password;

    private String email;

}