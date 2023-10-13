package com.example.orderservice.Feigns;

import com.example.orderservice.Feigns.Dto.InventoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "inventoryService", url = "http://localhost:8082/api/v1/inventory")
public interface inventoryRepositoryI {
    @GetMapping
    List<InventoryDto> isInStock(@RequestParam List<String> skuCode);

}
