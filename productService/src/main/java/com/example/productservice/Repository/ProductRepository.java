package com.example.productservice.Repository;

import com.example.productservice.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, BigDecimal> {

    Page<Product> findAllByCode(Optional<BigDecimal> code, Pageable pageable);
}
