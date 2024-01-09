package com.example.inventoryservice.Feigns;

import com.example.inventoryservice.Dto.InventoryDto;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "orderService", url = "http://localhost:8081/api/v1/order/notify")
public interface OrderRepositoryI {
    @PostMapping
    void notifyProductAdded(@RequestBody List<InventoryDto> inventoryDto);
}
