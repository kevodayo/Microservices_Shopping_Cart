package com.example.inventoryservice.Mapper;

import com.example.inventoryservice.Dto.InventoryDto;
import com.example.inventoryservice.Model.Inventory;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

@RequiredArgsConstructor
public class InventoryMapper {

    private final ModelMapper modelMapper;
    public Inventory toEntity(InventoryDto inventoryDto){
        Inventory mapped = modelMapper.map(inventoryDto, Inventory.class);
        return mapped;
    }
    public InventoryDto toDto(Inventory inventory){
       InventoryDto mapped = modelMapper.map(inventory, InventoryDto.class);
       return mapped;
    }
}
