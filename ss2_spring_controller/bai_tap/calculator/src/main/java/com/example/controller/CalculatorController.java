package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {
    @GetMapping("")
    public String calculate (@RequestParam(required = false) Integer number1, Integer number2, String calculate ,Model model) {
        if (number1 == null & number2 == null) {
            return "calculator";
        }
        int result = 0;
        String message = "";
        String calculationMessage = "";
        switch (calculate) {
            case "Addition(+)":
                result = number1 + number2;
                calculationMessage = "Addition";
                break;
            case "Subtraction(-)":
                result = number1 - number2;
                calculationMessage = "Subtraction";
                break;
            case "Multiplication(*)":
                result = number1 * number2;
                calculationMessage = "Multiplication";
                break;
            case "Division(/)":
                if (number2 != 0) {
                    result = number1 / number2;
                    calculationMessage = "Division";
                } else {
                    message = "Hãy nhập số khác 0";
                }
                break;
        }
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        model.addAttribute("result", result);
        model.addAttribute("message", message);
        model.addAttribute("calculationMessage", calculationMessage);
        return "calculator";
    }
}
