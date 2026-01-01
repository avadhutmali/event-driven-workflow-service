package com.saga.order_service;

import com.example.saga.OrderCreatedEventDTO;
import com.example.saga.OrderItemDTO;
import com.example.saga.OrderRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class OrderServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

    @Autowired
    private OrderProducer sender;

    @Override
    public void run(String... args) throws Exception {
        OrderItemDTO orderItem = new OrderItemDTO(909L,2,101.1);
        List<OrderItemDTO> ls = new ArrayList<>();
        ls.add(orderItem);
        OrderCreatedEventDTO order = new OrderCreatedEventDTO(101L,101L,ls,202.2,"mali.avadhut7@gmail.com");
        sender.sendOrder(order,"inventory");
        System.out.println("Sending the msg");
    }
}
