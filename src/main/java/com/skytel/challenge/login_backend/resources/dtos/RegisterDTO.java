package com.skytel.challenge.login_backend.resources.dtos;


import com.skytel.challenge.login_backend.entities.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


public class RegisterDTO {

    @NotEmpty(message = "firstName must not be empty")
    private String firstName;

    @NotEmpty(message = "lastName must not be empty")
    private String lastName;

    @NotEmpty(message = "phone must not be empty")
    @Pattern(regexp = "[0-9]+")
    private String phone;

    @NotEmpty(message = "email must not be empty")
    @Email(message = "email must be a valid Email address")
    private String email;

    private String token;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User dtoToUser() {
        User user = new User();
        user.setFirstName(this.getFirstName());
        user.setLastName(this.getLastName());
        user.setPhone(this.getPhone());
        user.setEmail(this.getEmail());
        return user;
    }


}
