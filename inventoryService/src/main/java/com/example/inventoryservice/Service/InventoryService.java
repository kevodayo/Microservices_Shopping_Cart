package com.example.inventoryservice.Service;

import com.example.inventoryservice.Dto.InventoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InventoryService {
    List<InventoryDto> isInStock(List<String> skuCode);

    List<InventoryDto> addToStock(List<InventoryDto> inventoryDtoList);
}
