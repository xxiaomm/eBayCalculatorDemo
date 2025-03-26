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
public class AddStrategy implements OperationStrategy {

    @Override
    public BigDecimal apply(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }

    @Override
    public Operation getOperation() {
        return Operation.ADD;
    }
}
