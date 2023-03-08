package com.example.book_borrowing_app.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Exception {
    @ExceptionHandler(java.lang.Exception.class)
    public String handleException () {
        return "/error";
    }
}
