package com.example.ebaycalculatordemo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Create 03/2025
 * @Author xiao
 * @Description
 */

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public static void handle(Exception e) {
        System.out.println("[ERROR]: " + e.getMessage());
    }
}
