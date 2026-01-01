package com.saga.inventory_service;

import com.example.saga.OrderCreatedEventDTO;
import com.example.saga.OrderItemDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InventoryConsumer {

    @Autowired
    InventoryProducer producer;

    @RabbitListener(queues = "inventory-queue")
    public void consume(OrderCreatedEventDTO order){
        System.out.println("Order has come");
        System.out.println("User Id is "+order.getUserId());
        System.out.println("Order Id is "+order.getOrderId());
        System.out.println("Order total Amount is "+order.getTotalAmount());
        System.out.println("Inventory is ready and send for payment service");

        producer.produce(order);
    }
}
