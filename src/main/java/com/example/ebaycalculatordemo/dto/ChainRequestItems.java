package com.example.ebaycalculatordemo.dto;

import com.example.ebaycalculatordemo.enums.Operation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

/**
 * @Create 03/2025
 * @Author xiao
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChainRequestItems {
//    @NotNull
    Object num;
    Operation op;
}
