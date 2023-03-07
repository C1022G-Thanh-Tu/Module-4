package com.example.validate_registration_form.service;

import com.example.validate_registration_form.dto.IUserDTO;
import com.example.validate_registration_form.dto.UserDTO;
import com.example.validate_registration_form.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    void create(User user);
}
