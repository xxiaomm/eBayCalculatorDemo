package com.example.ebaycalculatordemo.utils;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Create 03/2025
 * @Author xiao
 * @Description
 */

public class NumberConverterTest {

    @Test
    public void testConvertInteger() {
        assertEquals(new BigDecimal("5"), NumberConverter.toBigDecimal(5));
    }

    @Test
    public void testConvertDouble() {
        assertEquals(new BigDecimal("3.14"), NumberConverter.toBigDecimal(3.14));
    }

    @Test
    public void testConvertFloat() {
        assertEquals(new BigDecimal("2.5"), NumberConverter.toBigDecimal(2.5f));
    }

    @Test
    public void testConvertLong() {
        assertEquals(new BigDecimal("10000000000"), NumberConverter.toBigDecimal(10_000_000_000L));
    }

    @Test
    public void testConvertString() {
        assertEquals(new BigDecimal("42.42"), NumberConverter.toBigDecimal("42.42"));
    }

    @Test
    public void testNullInput() {
        assertThrows(IllegalArgumentException.class, () -> NumberConverter.toBigDecimal(null));
    }

    @Test
    public void testUnsupportedType() {
        assertThrows(IllegalArgumentException.class, () -> NumberConverter.toBigDecimal(new Object()));
    }
}
