package com.example.inventoryservice.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryDto {
    private BigDecimal code;
    private String skuCode;
    private BigDecimal quantity;
}
