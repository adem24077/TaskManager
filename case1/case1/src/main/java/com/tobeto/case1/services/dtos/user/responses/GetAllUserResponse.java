package com.tobeto.case1.services.dtos.user.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUserResponse {

    private String id;

    private String email;

    private String username;

    private String password;

}
