package com.example.ebaycalculatordemo.utils;

import java.math.BigDecimal;

/**
 * @Create 03/2025
 * @Author xiao
 * @Description
 */

public class NumberConverter {
    public static BigDecimal toBigDecimal(Object value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }

        if (value instanceof BigDecimal) return (BigDecimal) value;
        if (value instanceof Integer) return BigDecimal.valueOf((Integer) value);
        if (value instanceof Long) return BigDecimal.valueOf((Long) value);
        if (value instanceof Float) return BigDecimal.valueOf(((Float) value).doubleValue());
        if (value instanceof Double) return BigDecimal.valueOf((Double) value);
        if (value instanceof String) return new BigDecimal((String) value);

        throw new IllegalArgumentException("Unsupported type: " + value.getClass().getName());
    }
}
