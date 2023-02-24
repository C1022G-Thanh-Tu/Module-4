package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/greeting")
public class GreetingController {
    @GetMapping("")
    public String greeting (@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
