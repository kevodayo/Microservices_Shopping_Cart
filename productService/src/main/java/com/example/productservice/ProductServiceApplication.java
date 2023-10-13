package com.example.productservice;

import com.example.productservice.mapper.ProductMapper;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductServiceApplication {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    @Bean
    public ProductMapper productMapper(ModelMapper modelMapper){
        return new ProductMapper(modelMapper);
    }
    public static void main(String[] args) {

        SpringApplication.run(ProductServiceApplication.class, args);
    }

}
