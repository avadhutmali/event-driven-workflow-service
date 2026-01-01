package com.saga.order_service;

import com.example.saga.OrderCreatedEventDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderProducer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendOrder(OrderCreatedEventDTO order, String key){
        System.out.println("Sending the Order to the Inventory");
        rabbitTemplate.convertAndSend("saga",key,order);
    }

}
