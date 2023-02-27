package com.example.controller;

import com.example.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {
    @Autowired
    ICalculatorService calculatorService;
    @GetMapping("")
    public String calculate (@RequestParam(required = false) Double number1, Double number2,
                             String calculate ,Model model) {
        if (number1 == null & number2 == null) {
            return "calculator";
        }
        String message = "";
        String calculationMessage = "";
        double result = calculatorService.performCalculation(calculate, number1, number2);
        switch (calculate) {
            case "Addition(+)":
                calculationMessage = "Addition";
                break;
            case "Subtraction(-)":
                calculationMessage = "Subtraction";
                break;
            case "Multiplication(*)":
                calculationMessage = "Multiplication";
                break;
            case "Division(/)":
                if (result != 0) {
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
