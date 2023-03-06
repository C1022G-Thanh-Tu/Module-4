package com.example.controller;

import com.example.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static void main(String[] args) {
        int l =3113;
        int r = 3223;
        String[] arr = new String[r-l+1];
        int j = 0;
        for (int i = l; i < r+1; i++) {
            arr[j] = Integer.toString(i);
            j++;
        }
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int k = 0; k < arr[i].length(); k++) {
                if (arr[i].charAt(k) == arr[i].charAt(arr[i].length() - k - 1)) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                strings.add(arr[i]);
            }
        }
        int[] ints = new int[strings.size()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(strings.get(i));
        }
        System.out.println(Arrays.toString(ints));
    }
}
