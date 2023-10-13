package com.example.orderservice.Mapper;

import com.example.orderservice.Dto.OrderDto;
import com.example.orderservice.Model.Order;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

@RequiredArgsConstructor
public class OrderMapper {
    private final ModelMapper mapper;
    public Order toEntity(OrderDto orderDto){
        Order mapped = mapper.map(orderDto, Order.class);
        return mapped;
    }
    public OrderDto toDto(Order order){
        OrderDto mapped = mapper.map(order, OrderDto.class);
        return mapped;
    }
}
