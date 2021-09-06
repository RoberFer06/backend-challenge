package com.skytel.challenge.login_backend.resources;


import com.skytel.challenge.login_backend.resources.dtos.RegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RegisterUserResource {

    private final RegisterUserController registerUserController;

    @Autowired
    public RegisterUserResource(RegisterUserController registerUserController) {
        this.registerUserController = registerUserController;
    }


    @PostMapping("/register")
    public RegisterDTO registerUser(@Valid @RequestBody RegisterDTO registerUser) {
        return this.registerUserController.registerUser(registerUser);
    }
}
