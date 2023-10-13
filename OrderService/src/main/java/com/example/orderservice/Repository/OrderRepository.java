package com.example.orderservice.Repository;

import com.example.orderservice.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface OrderRepository extends JpaRepository<Order, BigDecimal> {
}
