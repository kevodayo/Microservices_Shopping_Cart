package com.example.orderservice.Service;

import com.example.orderservice.Dto.OrderDto;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    OrderDto placeorder(OrderDto orderDto);
}
