package com.example.service.impl;

import com.example.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public double performCalculation(String calculate, double number1, double number2) {
        switch (calculate) {
            case "Addition(+)":
                return number1 + number2;
            case "Subtraction(-)":
                return number1 - number2;
            case "Multiplication(*)":
                return number1 * number2;
            case "Division(/)":
                if (number2 != 0) {
                    return number1 / number2;
                } else {
                    return 0;
                }
        }
        return 0;
    }
}
