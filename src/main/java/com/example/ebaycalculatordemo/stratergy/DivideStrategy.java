package com.example.ebaycalculatordemo.stratergy;

import com.example.ebaycalculatordemo.enums.Operation;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @Create 03/2025
 * @Author xiao
 * @Description
 */
@Component
public class DivideStrategy implements OperationStrategy{
    @Override
    public BigDecimal apply(BigDecimal a, BigDecimal b) {
        if (b.compareTo(BigDecimal.ZERO) == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a.divide(b, 2, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public Operation getOperation() {
        return Operation.DIVIDE;
    }
}
