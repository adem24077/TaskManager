package com.tobeto.case1.services.concretes;

import com.tobeto.case1.core.services.JwtService;
import com.tobeto.case1.entities.concretes.Role;
import com.tobeto.case1.entities.concretes.User;
import com.tobeto.case1.services.abstracts.AuthService;
import com.tobeto.case1.services.abstracts.UserService;
import com.tobeto.case1.services.dtos.user.requests.AddUserRequest;
import com.tobeto.case1.services.dtos.user.requests.LoginRequest;
import com.tobeto.case1.services.dtos.user.responses.AuthResponse;
import com.tobeto.case1.services.rules.UserBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthManager implements AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    private final UserBusinessRules userBusinessRules;
    @Override
    public void register(AddUserRequest addUserRequest) {

        this.userBusinessRules.checkIfEmailExists(addUserRequest.getEmail());

        User user = User.builder()
                .email(addUserRequest.getEmail())
                .authorities(List.of(Role.USER))
                .password(passwordEncoder.encode(addUserRequest.getPassword()))
                .build();
        Integer createdUserId = userService.add(user);

        addUserRequest.setUserId(createdUserId);

        userService.add(addUserRequest);
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        AuthResponse response = new AuthResponse();
        if(authentication.isAuthenticated())
        {
            response.setToken(jwtService.generateToken(loginRequest.getEmail()));
            User user =  userService.findByEmail(loginRequest.getEmail());
            response.setId(user.getId());
            response.setRole(user.getAuthorities().get(0).name());
            return response;
        }

        throw new RuntimeException("Kullanıcı adı ya da şifre yanlış");
    }

}