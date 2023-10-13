package com.example.productservice.service;

import com.example.productservice.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    ProductDto saveProduct(ProductDto productDto);
    List<ProductDto> getAllProducts(int pageNo, int pageSize, Optional<BigDecimal> code);

    ProductDto editProduct(ProductDto productDto, BigDecimal code);
}
