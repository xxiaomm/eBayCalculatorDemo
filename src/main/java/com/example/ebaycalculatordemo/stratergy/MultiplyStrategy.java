package com.example.ebaycalculatordemo.stratergy;

import com.example.ebaycalculatordemo.enums.Operation;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Create 03/2025
 * @Author xiao
 * @Description
 */
@Component
public class MultiplyStrategy implements OperationStrategy{
    @Override
    public BigDecimal apply(BigDecimal a, BigDecimal b) {
        return a.multiply(b).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public Operation getOperation() {
        return Operation.MULTIPLY;
    }
}
