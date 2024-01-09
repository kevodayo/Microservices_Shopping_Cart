package com.example.orderservice.Service;

import com.example.orderservice.Dto.OrderDto;
import com.example.orderservice.Feigns.Dto.InventoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    OrderDto placeorder(OrderDto orderDto);

    void notifyProductAdded(List<InventoryDto> inventoryDto);
}
