package com.example.ebaycalculatordemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.jetbrains.annotations.NotNull;


import java.math.BigDecimal;
import java.util.List;

/**
 * @Create 03/2025
 * @Author xiao
 * @Description
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChainRequest {
//    @NotNull
    Object initialValue;
    List<ChainRequestItems> items;


}
