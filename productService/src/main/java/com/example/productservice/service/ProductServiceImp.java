package com.example.productservice.service;

import com.example.productservice.Repository.ProductRepository;
import com.example.productservice.dto.ProductDto;
import com.example.productservice.mapper.ProductMapper;
import com.example.productservice.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImp implements ProductService{

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    @Override
    public ProductDto saveProduct(ProductDto productDto) {

        Product product = productRepository.save(productMapper.toEntity(productDto));

        return productMapper.toDto(product);
    }

    @Override
    public List<ProductDto> getAllProducts(int pageNo, int pageSize, Optional<BigDecimal> code) {

        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);

        if(code.isPresent()){
            return productRepository.findAllByCode(code, pageRequest)
                    .getContent().stream()
                    .map(productMapper::toDto).collect(Collectors.toList());
        }
        return productRepository.findAll(pageRequest).getContent()
                .stream().map(productMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ProductDto editProduct(ProductDto productDto, BigDecimal code) {

        Product product = productRepository.findById(code)
                .orElseThrow(()->new RuntimeException("No such product found"));
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());

        Product updatedProduct = productRepository.save(product);
        return productMapper.toDto(updatedProduct);
    }
}
