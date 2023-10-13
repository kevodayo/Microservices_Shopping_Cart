package com.example.orderservice.Mapper;

import com.example.orderservice.Dto.OrderDto;
import com.example.orderservice.Dto.OrderLineItemsDto;
import com.example.orderservice.Model.Order;
import com.example.orderservice.Model.OrderLineItems;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
@RequiredArgsConstructor
public class OrderLineItemsMapper {
    private final ModelMapper mapper;
    public OrderLineItems toEntity(OrderLineItemsDto orderLineItemsDto){
        OrderLineItems mapped = mapper.map(orderLineItemsDto, OrderLineItems.class);
        return mapped;
    }
    public OrderLineItemsDto toDto(OrderLineItems orderLineItems){
        OrderLineItemsDto mapped = mapper.map(orderLineItems, OrderLineItemsDto.class);
        return mapped;
    }
}
