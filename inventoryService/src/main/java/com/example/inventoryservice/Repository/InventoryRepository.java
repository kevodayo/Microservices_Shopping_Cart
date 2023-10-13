package com.example.inventoryservice.Repository;

import com.example.inventoryservice.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, BigDecimal> {
//    Optional<Inventory> findBySkuCode(List<String> skuCode);
    List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
