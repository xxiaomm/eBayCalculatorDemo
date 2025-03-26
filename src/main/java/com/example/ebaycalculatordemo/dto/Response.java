package com.example.ebaycalculatordemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Create 03/2025
 * @Author xiao
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Response<T> implements Serializable {
    private String code;
    private String message;
    private T data;

    public static <T> Response<T> success(T data) {
        return new Response<>("200", "Success", data);
    }

    public static <T> Response<T> fail(String message) {
        return new Response<>("400", message, null);
    }
}

