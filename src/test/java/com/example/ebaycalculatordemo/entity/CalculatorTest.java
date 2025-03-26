package com.example.ebaycalculatordemo.entity;

import com.example.ebaycalculatordemo.enums.Operation;
import com.example.ebaycalculatordemo.stratergy.*;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Create 03/2025
 * @Author xiao
 * @Description
 */

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        Map<Operation, OperationStrategy> strategies = new EnumMap<>(Operation.class);
        strategies.put(Operation.ADD, new AddStrategy());
        strategies.put(Operation.SUBTRACT, new SubtractStrategy());
        strategies.put(Operation.MULTIPLY, new MultiplyStrategy());
        strategies.put(Operation.DIVIDE, new DivideStrategy());
        calculator = new Calculator(strategies);
    }

    @Test
    void testAdd() {
        BigDecimal result = calculator.calculate(Operation.ADD, new BigDecimal("2"), new BigDecimal("3"));
        assertEquals(new BigDecimal("5.00"), result);
    }

    @Test
    void testSubtract() {
        BigDecimal result = calculator.calculate(Operation.SUBTRACT, new BigDecimal("3"), new BigDecimal("2"));
        assertEquals(new BigDecimal("1.00"), result);
    }

    @Test
    void testMultiply() {
        BigDecimal result = calculator.calculate(Operation.MULTIPLY, new BigDecimal("2"), new BigDecimal("3"));
        assertEquals(new BigDecimal("6.00"), result);
    }

    @Test
    void testDivide() {
        BigDecimal result = calculator.calculate(Operation.DIVIDE, new BigDecimal("5"), new BigDecimal("2"));
        assertEquals(new BigDecimal("2.50"), result);
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () ->
            calculator.calculate(Operation.DIVIDE, new BigDecimal("5"), BigDecimal.ZERO)
        );
    }

}
