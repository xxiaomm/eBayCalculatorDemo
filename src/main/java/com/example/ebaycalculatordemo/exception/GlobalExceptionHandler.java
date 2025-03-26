package com.example.ebaycalculatordemo.exception;

import com.example.ebaycalculatordemo.dto.Response;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Create 03/2025
 * @Author xiao
 * @Description
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Response<String>> handleIllegalArgument(IllegalArgumentException ex) {
//        Response<String> response = new Response<>(HttpStatus.BAD_REQUEST.toString(), ex.getMessage(), null);
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        return ResponseEntity
            .badRequest()
            .body(Response.fail(ex.getMessage()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Response<Object>> handleInvalidEnum(HttpMessageNotReadableException ex) {
        Throwable cause = ex.getCause();

        if (cause instanceof InvalidFormatException invalidEx) {
            Object invalidValue = invalidEx.getValue();
            return ResponseEntity
                .badRequest()
                .body(Response.fail("Unsupported operation value: " + invalidValue));
        }

        return ResponseEntity
            .badRequest()
            .body(Response.fail("Malformed request: " + ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public static void handle(Exception e) {
        System.out.println("[ERROR]: " + e.getMessage());
    }
}
