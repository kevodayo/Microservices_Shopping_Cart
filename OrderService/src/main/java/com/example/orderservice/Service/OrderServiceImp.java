package com.example.orderservice.Service;

import com.example.orderservice.Dto.OrderDto;
import com.example.orderservice.Feigns.Dto.InventoryDto;
import com.example.orderservice.Feigns.inventoryRepositoryI;
import com.example.orderservice.Mapper.OrderLineItemsMapper;
import com.example.orderservice.Mapper.OrderMapper;
import com.example.orderservice.Model.Order;
import com.example.orderservice.Model.OrderLineItems;
import com.example.orderservice.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImp implements OrderService{

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final inventoryRepositoryI inventoryRepositoryItest;
    private final OrderLineItemsMapper orderLineItemsMapper;

    @Override
    public OrderDto placeorder(OrderDto orderDto) {

        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderDto.getOrderLineItemsDtos().stream()
                .map(orderLineItemsMapper::toEntity).toList();

        order.setOrderLineItems(orderLineItems);

        List<String> skuCodes = order.getOrderLineItems().stream()
                .map(OrderLineItems::getSkuCode).toList();
        List<InventoryDto> skuCodesFromDB = inventoryRepositoryItest.
                isInStock(skuCodes).stream().toList();
       boolean check =  skuCodesFromDB.stream().allMatch(item->
            item.getSkuCode().equals(skuCodes)
        );
       if (check){
           log.info("A list of skucodes {}", skuCodesFromDB);
           orderRepository.save(order);
       }else {
           throw new IllegalArgumentException("Product is not in stock, please try again later");
       }
        return orderMapper.toDto(order);
    }
}
