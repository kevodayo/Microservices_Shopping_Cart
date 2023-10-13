package com.example.orderservice.Model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "OrderLineItems")
public class OrderLineItems {
    @Id
    @GeneratedValue
    private BigDecimal id;
    private String skuCode;
    private BigDecimal price;
    private BigDecimal quantity;
}
