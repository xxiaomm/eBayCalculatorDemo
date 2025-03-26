package com.example.ebaycalculatordemo.entity;

import com.example.ebaycalculatordemo.enums.Operation;
import com.example.ebaycalculatordemo.stratergy.OperationStrategy;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @Create 03/2025
 * @Author xiao
 * @Description
 * Basic Calculation Method: The calculate method should take two numbers and an
 * operation, and return the result of applying the operation to the two numbers. For
 * example, calculate(Operation.ADD, 2, 3) should return 5.
 * Chaining Functionality: The chaining method should allow users to start with an initial value
 * and apply multiple operations in sequence. For example, starting with 5, the user should be
 * able to add 3, then multiply by 2, and retrieve the final result.
 * Handling Unsupported Operations: If an operation is requested that isn't supported, the
 * solution should handle this gracefully, either by throwing an exception or providing a
 * meaningful error message.
 */


public class Calculator {

    private final Map<Operation, OperationStrategy> strategies;

    public Calculator(Map<Operation, OperationStrategy> strategies) {
        this.strategies = strategies;
    }

    public BigDecimal calculate(Operation op, BigDecimal a, BigDecimal b) {
        OperationStrategy strategy = strategies.get(op);
        if (strategy == null)
            throw new UnsupportedOperationException("Unsupported operation: " + op);
        return strategy.apply(a, b);
    }
}