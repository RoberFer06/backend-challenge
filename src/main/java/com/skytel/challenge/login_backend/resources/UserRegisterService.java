package com.skytel.challenge.login_backend.resources;

import com.skytel.challenge.login_backend.resources.dtos.RegisterDTO;

public interface UserRegisterService {

    RegisterDTO registerUser(RegisterDTO userRegister);
}
