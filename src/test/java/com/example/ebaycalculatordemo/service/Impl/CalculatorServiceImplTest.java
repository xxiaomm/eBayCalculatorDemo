package com.example.ebaycalculatordemo.service.Impl;

import com.example.ebaycalculatordemo.dto.CalculateRequest;
import com.example.ebaycalculatordemo.dto.ChainRequest;
import com.example.ebaycalculatordemo.dto.ChainRequestItems;
import com.example.ebaycalculatordemo.enums.Operation;
import com.example.ebaycalculatordemo.service.CalculatorService;
import com.example.ebaycalculatordemo.stratergy.*;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Create 03/2025
 * @Author xiao
 * @Description
 */

public class CalculatorServiceImplTest {
    private CalculatorService service;

    @BeforeEach
    void setUp() {
        Map<String, OperationStrategy> beans = new HashMap<>();
        List<OperationStrategy> strategies = List.of(
            new AddStrategy(), new SubtractStrategy(),
            new MultiplyStrategy(), new DivideStrategy()
        );
        service = new CalculatorServiceImpl(toStrategyMap(strategies));
    }

    private Map<String, OperationStrategy> toStrategyMap(List<OperationStrategy> list) {
        Map<String, OperationStrategy> map = new HashMap<>();
        for (OperationStrategy strategy : list) {
            map.put(strategy.getClass().getSimpleName(), strategy);
        }
        return map;
    }

    @Test
    void testSingleCalculation() {
        CalculateRequest req = new CalculateRequest();
        req.setOp(Operation.ADD);
        req.setNum1(new BigDecimal("2"));
        req.setNum2(new BigDecimal("3"));

        BigDecimal result = service.calculate(req);
        assertEquals(new BigDecimal("5.00"), result);
    }

    @Test
    void testChainedCalculation() {
        ChainRequest req = new ChainRequest();
        req.setInitialValue(new BigDecimal("5"));
        List<ChainRequestItems> items = new ArrayList<>();
        items.add(new ChainRequestItems(Operation.ADD, new BigDecimal("3")));
        items.add(new ChainRequestItems(Operation.MULTIPLY, new BigDecimal("2")));
        req.setItems(items);

        BigDecimal result = service.calculateChained(req);
        assertEquals(new BigDecimal("16.00"), result); // (5 + 3) * 2
    }
}
