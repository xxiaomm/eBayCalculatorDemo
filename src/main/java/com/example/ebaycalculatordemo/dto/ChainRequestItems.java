package com.example.ebaycalculatordemo.dto;

import com.example.ebaycalculatordemo.enums.Operation;
import lombok.Data;
//import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

/**
 * @Create 03/2025
 * @Author xiao
 * @Description
 */
@Data
public class ChainRequestItems {
//    @NotNull
    Object num;
    Operation op;
}
