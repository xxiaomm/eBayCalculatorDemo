package com.example.ebaycalculatordemo.stratergy;

import com.example.ebaycalculatordemo.enums.Operation;

import java.math.BigDecimal;

/**
 * @Create 03/2025
 * @Author xiao
 * @Description
 */

public interface OperationStrategy {
    BigDecimal apply(BigDecimal a, BigDecimal b);
    Operation getOperation();
}
