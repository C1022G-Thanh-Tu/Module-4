package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/currency")
public class CurrencyCalculatorController {
    @GetMapping ("")
    public String converseCurrency (@RequestParam(required = false) Double usd, Model model) {
        if (usd == null) {
            model.addAttribute("usd", usd);
            return "currency";
        }
        double vnd = usd*23792.50;
        model.addAttribute("usd", usd);
        model.addAttribute("vnd", vnd);
        return "currency";
    }
}
