package com.example.ebaycalculatordemo.dto;

import com.example.ebaycalculatordemo.enums.Operation;
import lombok.Data;

/**
 * @Create 03/2025
 * @Author xiao
 * @Description
 */

@Data
public class CalculateRequest {

    private Operation op;
//    @NotNull
    private Object num1;
//    @NotNull
    private Object num2;

}
