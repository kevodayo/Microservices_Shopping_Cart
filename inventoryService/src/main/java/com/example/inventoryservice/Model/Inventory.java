package com.example.inventoryservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue
    private BigDecimal code;
    private String skuCode;
    private BigDecimal quantity;
}
