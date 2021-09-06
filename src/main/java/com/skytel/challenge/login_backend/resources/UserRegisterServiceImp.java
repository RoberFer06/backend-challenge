package com.skytel.challenge.login_backend.resources;

import com.skytel.challenge.login_backend.resources.dtos.RegisterDTO;
import com.skytel.challenge.login_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterServiceImp implements UserRegisterService{

    private final UserRepository userRepository;

    @Autowired
    public UserRegisterServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public RegisterDTO registerUser(RegisterDTO userRegister) {
        this.userRepository.save(userRegister.dtoToUser());
        return userRegister;
    }
}
