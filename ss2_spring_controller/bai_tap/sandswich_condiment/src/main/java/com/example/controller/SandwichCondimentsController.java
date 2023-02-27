package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
@RequestMapping("/save")
public class SandwichCondimentsController {
    @GetMapping("")
    public String save (@RequestParam(required = false) String[] condiment, Model model) {
        if (condiment == null) {
            model.addAttribute("condimentList", "");
            return "sandwichCondiment";
        }
        model.addAttribute("condimentList", Arrays.toString(condiment));
        return "sandwichCondiment";
    }
}
