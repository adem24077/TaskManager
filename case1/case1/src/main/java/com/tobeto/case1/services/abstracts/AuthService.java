package com.tobeto.case1.services.abstracts;

import com.tobeto.case1.services.dtos.user.requests.AddUserRequest;
import com.tobeto.case1.services.dtos.user.requests.CreateUserRequest;
import com.tobeto.case1.services.dtos.user.requests.LoginRequest;
import com.tobeto.case1.services.dtos.user.responses.AuthResponse;

public interface AuthService {
    void register(AddUserRequest addUserRequest);
    AuthResponse login(LoginRequest loginRequest);

}