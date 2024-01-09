package com.example.inventoryservice.Service;

import com.example.inventoryservice.Dto.InventoryDto;
import com.example.inventoryservice.Mapper.InventoryMapper;
import com.example.inventoryservice.Model.Inventory;
import com.example.inventoryservice.Repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryServiceImp implements InventoryService{

    private final InventoryRepository inventoryRepository;
    private final InventoryMapper inventoryMapper;
    @Override
    public List<InventoryDto> isInStock(List<String> skuCode) {
        log.info("skucodes "+ skuCode);
       return inventoryRepository.
               findBySkuCodeIn(skuCode).stream()
               .map(inventoryMapper::toDto).toList();
    }

    @Override
    public List<InventoryDto> addToStock(List<InventoryDto> inventoryDtoList) {

        List<Inventory> inventoryList = inventoryDtoList.stream()
                .map(inventoryMapper::toEntity).toList();
        List<Inventory> response = inventoryRepository.saveAll(inventoryList);
        return response.stream()
                .map(inventoryMapper::toDto).toList();
    }
}
