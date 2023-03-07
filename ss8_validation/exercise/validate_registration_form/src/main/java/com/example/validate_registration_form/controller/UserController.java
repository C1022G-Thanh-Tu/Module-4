package com.example.validate_registration_form.controller;

import com.example.validate_registration_form.dto.UserDTO;
import com.example.validate_registration_form.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("")
    public String showList (Model model) {
        model.addAttribute("userDtoList", userService.findAll());
        return "/list";
    }

    @GetMapping("/create")
    public String showCreationForm(Model model) {

        return "/create";
    }

//    @PostMapping("")
//    public String performCreation (@Valid @ModelAttribute U) {
//
//        return "redirect:/user";
//    }
}
