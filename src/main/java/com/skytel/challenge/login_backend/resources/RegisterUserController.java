package com.skytel.challenge.login_backend.resources;

import com.skytel.challenge.login_backend.resources.dtos.RegisterDTO;
import com.skytel.challenge.login_backend.exception.InvalidUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;

@Controller
public class RegisterUserController {

    private final UserRegisterService userRegisterService;

    @Autowired
    public RegisterUserController(UserRegisterService userRegisterService) {
        this.userRegisterService = userRegisterService;
    }

    public RegisterDTO registerUser(RegisterDTO user) {
        try {
            user = this.userRegisterService.registerUser(user);
        }catch (DataIntegrityViolationException ex) {
            throw new InvalidUserException(user.getEmail());
        }
        RegisterDTO userToken = new RegisterDTO();
        userToken.setToken(new GenerateTokenCase(user).generateToken());
        return userToken;
    }
}
