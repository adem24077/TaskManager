package com.tobeto.case1.controllers;

import com.tobeto.case1.services.abstracts.AuthService;
import com.tobeto.case1.services.dtos.user.requests.AddUserRequest;
import com.tobeto.case1.services.dtos.user.requests.CreateUserRequest;
import com.tobeto.case1.services.dtos.user.requests.LoginRequest;
import com.tobeto.case1.services.dtos.user.responses.AuthResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("login")
    @ResponseStatus(HttpStatus.OK)
    public AuthResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }
    @PostMapping("register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody AddUserRequest addUserRequest) {
        authService.register(addUserRequest);
    }

}