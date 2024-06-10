package com.tobeto.case1.services.concretes;

import com.tobeto.case1.core.mapper.services.ModelMapperService;
import com.tobeto.case1.entities.concretes.User;
import com.tobeto.case1.repositories.UserRepository;
import com.tobeto.case1.services.abstracts.UserService;
import com.tobeto.case1.services.dtos.user.requests.AddUserRequest;
import com.tobeto.case1.services.dtos.user.requests.UpdateUserRequest;
import com.tobeto.case1.services.dtos.user.responses.GetAllUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public void add(AddUserRequest request) {
        User user = this.modelMapperService.forRequest().map(request,User.class);
        this.userRepository.save(user);
    }

    @Override
    public void update(UpdateUserRequest request) {
        User user = this.modelMapperService.forRequest().map(request, User.class);
        this.userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        User user = this.userRepository.findById(id).orElseThrow();
        this.userRepository.delete(user);
    }

    @Override
    public Integer add(User user) {
        User createdUser = userRepository.save(user);
        return createdUser.getId();
    }


    @Override
    public List<GetAllUserResponse> getAll() {
        List<User> users = userRepository.findAll();
        List<GetAllUserResponse> userResponses = users.stream()
                .map(car -> this.modelMapperService.forResponse().map(car,GetAllUserResponse.class)).toList();
        return userResponses;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("No user found!"));

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("No user found!"));
    }
}
