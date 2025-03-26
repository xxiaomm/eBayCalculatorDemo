package com.example.ebaycalculatordemo.dto;

import com.example.ebaycalculatordemo.enums.Operation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Create 03/2025
 * @Author xiao
 * @Description
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculateRequest {

    private Operation op;
//    @NotNull
    private Object num1;
//    @NotNull
    private Object num2;

}
