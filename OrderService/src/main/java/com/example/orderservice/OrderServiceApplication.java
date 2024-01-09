package com.example.orderservice;

import com.example.orderservice.Mapper.OrderLineItemsMapper;
import com.example.orderservice.Mapper.OrderMapper;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class OrderServiceApplication {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    @Bean
    public OrderMapper orderMapper(ModelMapper modelMapper){
        return new OrderMapper(modelMapper);
    }
    @Bean
    public OrderLineItemsMapper orderLineItemsMapper(ModelMapper modelMapper){
       return new OrderLineItemsMapper(modelMapper);
    }
    @Bean
    WebClient webClient(WebClient.Builder builder) {
        return builder.build();
    }
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

}
