package com.tobeto.case1.services.rules;

import com.tobeto.case1.core.exceptions.BusinessException;
import com.tobeto.case1.repositories.UserRepository;
import com.tobeto.case1.services.constants.BusinessMessages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserBusinessRules {

    private UserRepository userRepository;

    public void checkIfEmailExists(String email){
        if(userRepository.existsUserByEmail(email)){
            throw new BusinessException(BusinessMessages.User.SAME_EMAIL_EXISTS);
        }
    }
}