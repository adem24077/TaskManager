package com.tobeto.case1.controllers;

import com.tobeto.case1.services.abstracts.UserService;
import com.tobeto.case1.services.dtos.user.requests.AddUserRequest;
import com.tobeto.case1.services.dtos.user.requests.UpdateUserRequest;
import com.tobeto.case1.services.dtos.user.responses.GetAllUserResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UserService userService;

    @PostMapping("/add")
    public void add(@RequestBody @Valid AddUserRequest request) {
        userService.add(request);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userService.delete(id);
    }
    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateUserRequest request) {
        userService.update(request);
    }
    @GetMapping("/getAll")
    public List<GetAllUserResponse> getAll() {
        return userService.getAll();
    }

}