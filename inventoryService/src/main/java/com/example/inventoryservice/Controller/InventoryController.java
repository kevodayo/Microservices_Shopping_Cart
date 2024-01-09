package com.example.inventoryservice.Controller;

import com.example.inventoryservice.Dto.InventoryDto;
import com.example.inventoryservice.Feigns.OrderRepositoryI;
import com.example.inventoryservice.Model.Inventory;
import com.example.inventoryservice.Service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/inventory")
public class InventoryController {
    private final InventoryService inventoryService;
    private final OrderRepositoryI orderRepositoryI;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryDto> isInStock(@RequestParam List<String> skuCode){
        return inventoryService.isInStock(skuCode);
    }
    @PostMapping("/addStock")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<InventoryDto> addToStock(@RequestBody List<InventoryDto> inventoryDtoList){
        orderRepositoryI.notifyProductAdded(inventoryDtoList);
        return inventoryService.addToStock(inventoryDtoList);
    }
}
