package com.example.inventoryservice.Service;

import com.example.inventoryservice.Dto.InventoryDto;
import com.example.inventoryservice.Mapper.InventoryMapper;
import com.example.inventoryservice.Repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryServiceImp implements InventoryService{

    private final InventoryRepository inventoryRepository;
    private final InventoryMapper inventoryMapper;
    @Override
    public List<InventoryDto> isInStock(List<String> skuCode) {
       return inventoryRepository.
               findBySkuCodeIn(skuCode).stream()
               .map(inventoryMapper::toDto).toList();
    }
}
