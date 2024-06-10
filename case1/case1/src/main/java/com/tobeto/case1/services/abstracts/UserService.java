package com.tobeto.case1.services.abstracts;

import com.tobeto.case1.entities.concretes.User;
import com.tobeto.case1.services.dtos.user.requests.AddUserRequest;
import com.tobeto.case1.services.dtos.user.requests.UpdateUserRequest;
import com.tobeto.case1.services.dtos.user.responses.GetAllUserResponse;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService{
    void add(AddUserRequest addUserRequest);
    void update(UpdateUserRequest updateUserRequest);
    void delete(Integer id);
    Integer add(User user);
    List<GetAllUserResponse> getAll();
    User findByEmail(String email);


}
