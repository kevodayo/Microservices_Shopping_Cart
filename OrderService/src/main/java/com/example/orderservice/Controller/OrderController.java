package com.example.orderservice.Controller;

import com.example.orderservice.Dto.OrderDto;
import com.example.orderservice.Service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
}
