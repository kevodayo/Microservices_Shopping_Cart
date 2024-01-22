package com.example.inventoryservice;

import com.example.inventoryservice.Mapper.InventoryMapper;
import com.example.inventoryservice.Model.Inventory;
import com.example.inventoryservice.Repository.InventoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.math.BigDecimal;

@SpringBootApplication
@EnableFeignClients
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class InventoryServiceApplication {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    @Bean
    public InventoryMapper inventoryMapper(ModelMapper modelMapper){
        return new InventoryMapper(modelMapper);
    }
    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
    public CommandLineRunner loadData(KafkaTemplate<String, String>  kafkaTemplate){
        return args -> {
            kafkaTemplate.send("inventory", "Hello Kevine");
        };
    }
}
