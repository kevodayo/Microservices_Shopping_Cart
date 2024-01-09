package com.example.orderservice.Controller;

import com.example.orderservice.Dto.OrderDto;
import com.example.orderservice.Feigns.Dto.InventoryDto;
import com.example.orderservice.Service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto placeorder (@RequestBody OrderDto orderDto){
        return orderService.placeorder(orderDto);
    }
    @PostMapping("/webhookTest")
    @ResponseStatus(HttpStatus.CREATED)
    public String handleProductAdded(@RequestBody List<InventoryDto> inventoryDto){
        return "Webhook received successfully";
    }
    @PostMapping("/notify")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void notifyProductAdded(@RequestBody List<InventoryDto> inventoryDto){
        orderService.notifyProductAdded(inventoryDto);
    }
}
