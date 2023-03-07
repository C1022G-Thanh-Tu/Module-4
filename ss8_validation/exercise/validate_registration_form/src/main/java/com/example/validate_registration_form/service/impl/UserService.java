package com.example.validate_registration_form.service.impl;

import com.example.validate_registration_form.dto.IUserDTO;
import com.example.validate_registration_form.dto.UserDTO;
import com.example.validate_registration_form.model.User;
import com.example.validate_registration_form.repository.IUserRepository;
import com.example.validate_registration_form.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public List<IUserDTO> findAll() {
        return userRepository.findAllUser();
    }

    @Override
    public void create(User user) {
        userRepository.save(user);
    }
}
