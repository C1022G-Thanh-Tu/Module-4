package com.example.controller;

import com.example.model.EmailBox;
import com.example.service.IEmailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;

@Controller
@RequestMapping("/email-box")
public class EmailBoxController {
    @Autowired
    IEmailBoxService emailBoxService;
    @GetMapping("")
    public String showUpdateForm(Model model) {
        model.addAttribute("emailBox",emailBoxService.getEmailBoxInfo());
        model.addAttribute("languageList", Arrays.asList("English", "Vietnamese", "Japanese", "Chinese"));
        model.addAttribute("pageSizeList", Arrays.asList("5", "10", "15", "25", "50", "100"));
        return "email";
    }

    @PostMapping("")
    public String performUpdate(@ModelAttribute EmailBox emailBox, Model model) {
        emailBoxService.updateEmailInfo(emailBox);
        model.addAttribute("emailBox", emailBox);
        return "detail";
    }
}
